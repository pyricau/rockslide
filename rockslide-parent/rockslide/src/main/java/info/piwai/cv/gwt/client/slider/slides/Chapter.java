package info.piwai.cv.gwt.client.slider.slides;

import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.VisibleSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public abstract class Chapter implements Iterable<Presentable>, HasHeaderWidget {

    private static final String IMPL_SUFFIX = "Impl";
    private List<Presentable> slides;
    private final List<String> slideNames = new ArrayList<String>();

    public final HasHeaderWidget getSlide(int slideIndex) {
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
     * May be overriden if you want to change the chapter name
     */
    public String getName() {
        return ClassHelper.getSimpleName(getClass());
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

    @Override
    public IsWidget getHeaderWidget() {
        return null;
    }
}
