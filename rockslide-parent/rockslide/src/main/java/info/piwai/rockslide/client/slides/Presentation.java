/**
 * Copyright (C) 2011 Pierre-Yves Ricau (py.ricau at gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.piwai.rockslide.client.slides;

import info.piwai.rockslide.client.shownotes.ShowNotesSender;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class Presentation extends Composite {

    private static PresentationUiBinder uiBinder = GWT.create(PresentationUiBinder.class);

    interface PresentationUiBinder extends UiBinder<Widget, Presentation> {}

    /** Chapter holding slides for the presentation */
    private Chapter chapter;

    /** Index of the displayed slide */
    private int index;

    private String chapterName;

    @UiField
    FlowPanel presentation;
    @UiField
    FlowPanel slidesPanel;

    @UiField
    SimplePanel header;

    private final ShowNotesSender showNotesSender;

    public Presentation(ShowNotesSender showNotesSender, IsWidget headerWidget) {
        this.showNotesSender = showNotesSender;
        initWidget(uiBinder.createAndBindUi(this));
        
        if (headerWidget != null) {
            header.setWidget(headerWidget);
        }
    }

    public void updateSlides(String chapterName, Chapter chapter) {
        index = 0;
        this.chapterName = chapterName;
        this.chapter = chapter;
        slidesPanel.clear();
        for (Presentable presentable : chapter) {
            Widget slideWidget = presentable.asWidget();
            slideWidget.setStyleName("slide");
            slidesPanel.add(slideWidget);
        }
    }

    /**
     * Display the previous slide Nothing done if the actual is the first one
     */
    public void displayPreviousSlide() {
        if (!chapter.isFirstSlide(index)) {
            displaySlide(index - 1);
        }
    }

    /**
     * Display the next slide Nothing done if the actual is the last one
     */
    public void displayNextSlide() {
        if (!chapter.isLastSlide(index)) {
            displaySlide(index + 1);
        }
    }

    /**
     * Display the slide from it's index
     * 
     * @param index
     */
    public void displaySlide(int index) {

        index = chapter.checkIndex(index);

        if (Math.abs(index - this.index) > 1) {

            String slideClass;
            if (index > this.index) {
                slideClass = "far-past";
            } else {
                slideClass = "far-future";
            }

            changeSlideClass(chapter.getSlideOrNull(this.index - 2), slideClass);
            changeSlideClass(chapter.getSlideOrNull(this.index - 1), slideClass);
            changeSlideClass(chapter.getSlideOrNull(this.index), slideClass);
            changeSlideClass(chapter.getSlideOrNull(this.index + 1), slideClass);
            changeSlideClass(chapter.getSlideOrNull(this.index + 2), slideClass);
        }

        this.index = index;
        changeSlideClass(chapter.getSlideOrNull(index - 2), "far-past");
        changeSlideClass(chapter.getSlideOrNull(index - 1), "past");
        Presentable currentSlide = chapter.getSlideOrNull(index);
        changeSlideClass(currentSlide, "current");
        changeSlideClass(chapter.getSlideOrNull(index + 1), "future");
        changeSlideClass(chapter.getSlideOrNull(index + 2), "far-future");

        String historyToken;
        if (index == 0) {
            historyToken = chapterName;
        } else {
            historyToken = chapterName + SlideViewer.SLIDE_PREFIX + chapter.getSlideName(index);
        }

        Analytics.trackModuleRelativePageView(historyToken);
        History.newItem(historyToken, false);

        slideVisible(index - 1);
        slideVisible(index + 1);
        slideVisible(index); // Must be last, has priority

        showNotesSender.sendShowNotes(currentSlide);
    }

    private void slideVisible(int index) {
        Visible slide = chapter.getSlideOrNull(index);
        if (slide != null) {
            slide.visible();
        }
    }

    private void changeSlideClass(Presentable slide, String styleName) {
        if (slide != null) {
            slide.asWidget().setStyleName("slide");
            slide.asWidget().addStyleName(styleName);
        }
    }

}
