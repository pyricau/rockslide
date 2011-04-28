package com.excilys.formation.gwt.client.slider;

import java.util.List;

import com.excilys.formation.gwt.client.slider.window.ShowNotesSender;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Presentation extends Composite {

    private static final String THREE_D_STYLE = "three-d";
    private static PresentationUiBinder uiBinder = GWT.create(PresentationUiBinder.class);

    interface PresentationUiBinder extends UiBinder<Widget, Presentation> {}

    /** Slides from the presentation */
    private List<Presentable> slides;
    /** Index of the displayed slide */
    private int index;

    private int currentChapter;

    @UiField
    FlowPanel presentation;
    @UiField
    FlowPanel slidesPanel;

    private final ShowNotesSender showNotesSender;

    public Presentation(ShowNotesSender showNotesSender) {
        this.showNotesSender = showNotesSender;
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void updateSlides(int chapterIndex, List<Presentable> slides) {
        if (slides != null && slides.size() > 0) {
            index = 1;
            currentChapter = chapterIndex;
            this.slides = slides;
            slidesPanel.clear();
            for (Presentable presentable : slides) {
                slidesPanel.add(presentable.asWidget());
            }
        }
    }

    /**
     * Display the previous slide Nothing done if the actual is the first one
     */
    public void displayPreviousSlide() {
        if (!isFirstPage()) {
            displaySlide(index - 1);
        }
    }

    /**
     * Display the next slide Nothing done if the actual is the last one
     */
    public void displayNextSlide() {
        if (!isLastPage()) {
            displaySlide(index + 1);
        }
    }

    /**
     * Display the slide from it's index
     * 
     * @param index
     */
    public void displaySlide(int index) {
        if (index < 1) {
            index = 1;
        } else if (index > slides.size()) {
            index = slides.size();
        }

        if (Math.abs(index - this.index) > 1) {

            String slideClass;
            if (index > this.index) {
                slideClass = "far-past";
            } else {
                slideClass = "far-future";
            }

            changeSlideClass(getSlide(this.index - 2), slideClass);
            changeSlideClass(getSlide(this.index - 1), slideClass);
            changeSlideClass(getSlide(this.index), slideClass);
            changeSlideClass(getSlide(this.index + 1), slideClass);
            changeSlideClass(getSlide(this.index + 2), slideClass);
        }

        this.index = index;
        changeSlideClass(getSlide(index - 2), "far-past");
        changeSlideClass(getSlide(index - 1), "past");
        Presentable currentSlide = getSlide(index);
        changeSlideClass(currentSlide, "current");
        changeSlideClass(getSlide(index + 1), "future");
        changeSlideClass(getSlide(index + 2), "far-future");
        String historyToken = SlideViewer.CHAPTER_PREFIX + currentChapter + SlideViewer.SLIDE_PREFIX + index;
        History.newItem(historyToken, false);

        slideVisible(index - 1);
        slideVisible(index + 1);
        slideVisible(index); // Must be last, has priority

        showNotesSender.sendShowNotes(currentSlide);
    }

    private void slideVisible(int index) {
        Visible slide = getSlide(index);
        if (slide != null) {
            slide.visible();
        }
    }

    /**
     * Is the slide displayed currently the first of the presentation
     * 
     * @return
     */
    private boolean isFirstPage() {
        return index <= 1;
    }

    /**
     * Is the slide displayed currently the last of the presentation
     * 
     * @return
     */
    private boolean isLastPage() {
        return index >= slides.size();
    }

    private Presentable getSlide(int slideNumber) {
        if (slideNumber > 0 && slideNumber <= slides.size()) {
            return slides.get(slideNumber - 1);
        } else {
            return null;
        }
    }

    private void changeSlideClass(Presentable slide, String styleName) {
        if (slide != null) {
            slide.asWidget().setStyleName("slide");
            slide.asWidget().addStyleName(styleName);
        }
    }

    public void switch3D() {
        if (RootPanel.get().getStyleName().contains(THREE_D_STYLE)) {
            RootPanel.get().removeStyleName(THREE_D_STYLE);
        } else {
            RootPanel.get().addStyleName(THREE_D_STYLE);
        }
    }
}
