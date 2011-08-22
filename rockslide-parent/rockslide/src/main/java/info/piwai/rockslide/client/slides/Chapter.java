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

import info.piwai.rockslide.client.shownotes.ElementSlideNotes;
import info.piwai.rockslide.client.shownotes.VisibleSlideNotes;
import info.piwai.rockslide.client.shownotes.WidgetSlideNotes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public abstract class Chapter implements Iterable<Presentable> {

    private static final String IMPL_SUFFIX = "Impl";
    
    private List<Presentable> slides;
    
    private final List<String> slideNames = new ArrayList<String>();
    
    private TableOfContentFactory tableOfContentFactory;

    public final Presentable getSlide(int slideIndex) {
        return ensureSlides().get(doCheckIndex(slideIndex));
    }

    public final Presentable getSlideOrNull(int slideIndex) {
        ensureSlides();
        if (slideIndex < 0) {
            return null;
        } else if (slideIndex >= slides.size()) {
            return null;
        }
        return slides.get(slideIndex);
    }

    public final int getSlideCount() {
        return ensureSlides().size();
    }

    @Override
    public final Iterator<Presentable> iterator() {
        return ensureSlides().iterator();
    }

    public final boolean isLastSlide(int slideIndex) {
        ensureSlides();
        return doCheckIndex(slideIndex) == slides.size() - 1;
    }

    public final boolean isFirstSlide(int slideIndex) {
        ensureSlides();
        return doCheckIndex(slideIndex) == 0;
    }

    /**
     * Unsafe: does not ensure slides
     */
    private final int doCheckIndex(int index) {
        if (index < 0) {
            index = 0;
        } else if (index >= slides.size()) {
            index = slides.size() - 1;
        }
        return index;
    }

    public final int checkIndex(int index) {
        ensureSlides();
        return doCheckIndex(index);
    }

    private List<Presentable> ensureSlides() {
        if (slides == null) {
            slides = new ArrayList<Presentable>();
            buildSlides();
            slides = Collections.unmodifiableList(slides);
        }
        return slides;
    }

    protected abstract void buildSlides();

    private String getUiBinderName(Object uiBinder) {
        String uiBinderClassSimpleName = ClassHelper.getSimpleName(uiBinder.getClass());

        int separatorIndex = uiBinderClassSimpleName.indexOf('_');

        String nameWithoutChapterClassName;
        if (separatorIndex != -1) {
            nameWithoutChapterClassName = uiBinderClassSimpleName.substring(separatorIndex);
        } else {
            nameWithoutChapterClassName = uiBinderClassSimpleName;
        }

        if (nameWithoutChapterClassName.endsWith(IMPL_SUFFIX)) {
            int finalNameLength = nameWithoutChapterClassName.length() - IMPL_SUFFIX.length();
            return nameWithoutChapterClassName.substring(0, finalNameLength);
        } else {
            return nameWithoutChapterClassName;
        }

    }

    protected final void addSlide(UiBinder<Element, ElementSlide> uiBinder) {
        addPresentable(new ElementSlide(uiBinder), getUiBinderName(uiBinder));
    }

    protected final void addNotesSlide(UiBinder<Element, ElementSlideNotes> uiBinder) {
        addPresentable(new ElementSlideNotes(uiBinder), getUiBinderName(uiBinder));
    }

    protected final void addWidgetNotesSlide(UiBinder<Widget, WidgetSlideNotes> uiBinder) {
        addPresentable(new WidgetSlideNotes(uiBinder), getUiBinderName(uiBinder));
    }

    protected final void addVisibleNotesSlide(UiBinder<Widget, VisibleSlideNotes> uiBinder) {
        addPresentable(new VisibleSlideNotes(uiBinder), getUiBinderName(uiBinder));
    }

    protected final void addWidgetSlide(UiBinder<Widget, WidgetSlide> uiBinder) {
        addPresentable(new WidgetSlide(uiBinder), getUiBinderName(uiBinder));
    }

    protected final void addVisibleSlide(UiBinder<Widget, VisibleSlide> uiBinder) {
        addPresentable(new VisibleSlide(uiBinder), getUiBinderName(uiBinder));
    }

    protected final void addPresentable(Presentable presentable) {
        addPresentable(presentable, ClassHelper.getSimpleName(presentable.getClass()));
    }
    
    protected final void addTableOfContent() {
        Presentable tableOfContent = tableOfContentFactory.buildTableOfContent();
        addPresentable(tableOfContent, tableOfContent.toString());
    }

    protected final void addPresentable(Presentable presentable, String slideName) {
        slides.add(presentable);
        String realSlideName;
        slideName = slideName.replace("_", "");

        if (slideNames.contains(slideName)) {
            int i = 1;
            do {
                i++;
                realSlideName = slideName + i;
            } while (slideNames.contains(realSlideName));
        } else {
            realSlideName = slideName;
        }
        slideNames.add(realSlideName);
    }

    /**
     * May be overriden if you want to change the chapter history name (defaults to chapter class name)
     */
    public String getHistoryName() {
        return ClassHelper.getSimpleName(getClass());
    }
    
    /**
     * May be overriden to change the chapter readable name (defaults to history name)
     */
    public String getReadableName() {
        return getHistoryName();
    }
    
    /**
     * Returns the slide index. The
     */
    public final int getSlideIndex(String slideName) {
        ensureSlides();
        return doCheckIndex(slideNames.indexOf(slideName));
    }

    public final String getSlideName(int slideIndex) {
        ensureSlides();
        return slideNames.get(doCheckIndex(slideIndex));
    }

    public void setSlideMapFactory(TableOfContentFactory slideMapFactory) {
        this.tableOfContentFactory = slideMapFactory;
    }

}
