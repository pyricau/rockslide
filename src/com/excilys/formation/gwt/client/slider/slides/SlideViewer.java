package com.excilys.formation.gwt.client.slider.slides;

import java.util.ArrayList;
import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.excilys.formation.gwt.client.slider.PresentationBuilder;
import com.excilys.formation.gwt.client.slider.PresentationEntryPoint;
import com.excilys.formation.gwt.client.slider.highlighter.HighlighterLoader;
import com.excilys.formation.gwt.client.slider.highlighter.HighlighterLoader.HighlighterLoadHandler;
import com.excilys.formation.gwt.client.slider.shownotes.ShowNotesSender;
import com.excilys.formation.gwt.client.slider.window.ChildWindow;
import com.excilys.formation.gwt.client.slider.window.WindowMessageListener;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;

public class SlideViewer implements ValueChangeHandler<String>, ChapterHolder {

    public static final String TRAINER_PARAM = "trainer";

    public static final String CHAPTER_PREFIX = "Chapter";
    public static final String SLIDE_PREFIX = "Slide";

    private Presentation presentation;

    private int currentChapter;

    private final List<Chapter> chapters = new ArrayList<Chapter>();

    private ChildWindow childWindow;

    private final PresentationBuilder presentationBuilder;

    private LoadingWidget loadingWidget;

    public SlideViewer(PresentationBuilder presentationBuilder) {
        this.presentationBuilder = presentationBuilder;
    }

    public void load() {
        startLoading();
        if ("true".equals(Location.getParameter(SlideViewer.TRAINER_PARAM))) {
            String features = "menubar=no," //
                    + "location=false," //
                    + "resizable=yes," //
                    + "scrollbars=yes," //
                    + "status=no," //
                    + "dependent=true";

            String showNotesUrl = Location.createUrlBuilder() //
                    .removeParameter(SlideViewer.TRAINER_PARAM) //
                    .setParameter(PresentationEntryPoint.SHOW_NOTES_PARAM, "true") //
                    .buildString();
            childWindow = ChildWindow.open(showNotesUrl, "shownotes", features);
            childWindow.registerListener("childLoaded", new WindowMessageListener<Void>() {
                @Override
                public void onMessage(Void message) {
                    doPreloadHighlighters();
                }
            });
        } else {
            doPreloadHighlighters();
        }
    }

    private void doPreloadHighlighters() {

        ArrayList<Brush> brushes = new ArrayList<Brush>();

        presentationBuilder.definePreloadedBrushes(brushes);

        HighlighterLoader.get().loadHighlighters(brushes, new HighlighterLoadHandler() {

            @Override
            public void onHighlightersLoaded() {
                loadSlideModule();
            }
        });
    }

    private void startLoading() {
        loadingWidget = new LoadingWidget();
        RootPanel.get().add(loadingWidget);
    }

    private void stopLoading() {
        loadingWidget.removeFromParent();
    }

    private void loadSlideModule() {
        Resources.instance.main().ensureInjected();
        presentationBuilder.loadChapters(this);

        presentation = new Presentation(new ShowNotesSender(childWindow));
        stopLoading();
        RootPanel rootPanel = RootPanel.get();
        rootPanel.add(presentation);
        initializeHistory();
        registerDocumentEvent(presentation);
    }

    @Override
    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    private void displayChapter(int chapterIndex) {
        displaySlide(chapterIndex, 1);
    }

    private void displaySlide(int chapterIndex, int slideIndex) {

        chapterIndex = checkChapterIndex(chapterIndex);
        if (chapterIndex != currentChapter) {
            currentChapter = chapterIndex;
            Chapter chapter = chapters.get(chapterIndex - 1);
            presentation.updateSlides(chapterIndex, chapter.getSlides());
        }
        presentation.displaySlide(slideIndex);
    }

    private int checkChapterIndex(int chapterIndex) {
        if (chapterIndex < 1) {
            chapterIndex = 1;
        } else if (chapterIndex > chapters.size()) {
            chapterIndex = chapters.size();
        }
        return chapterIndex;
    }

    private int checkSlideIndex(int slideIndex, List<Presentable> slides) {
        if (slideIndex < 1) {
            slideIndex = 1;
        } else if (slideIndex > slides.size()) {
            slideIndex = slides.size();
        }
        return slideIndex;
    }

    private void initializeHistory() {
        History.addValueChangeHandler(this);
        if ("".equals(History.getToken())) {
            displayChapter(1);
        } else {
            History.fireCurrentHistoryState();
        }
    }

    public native void registerDocumentEvent(Presentation presentation) /*-{
		var handleBodyKeyDown = function(event) {
			switch (event.keyCode) {
			case 37: // left arrow
				presentation.@com.excilys.formation.gwt.client.slider.slides.Presentation::displayPreviousSlide()();
				break;
			case 39: // right arrow
				presentation.@com.excilys.formation.gwt.client.slider.slides.Presentation::displayNextSlide()();
				break;
			case 51: // 3
				presentation.@com.excilys.formation.gwt.client.slider.slides.Presentation::switch3D()();
				break;
			}
		}
		$doc.addEventListener('keydown', handleBodyKeyDown, false);
		$doc.touchStartX = 0;
		$doc.addEventListener('touchstart', function(e) {
			$doc.touchStartX = e.touches[0].pageX;
		}, false);
		$doc
				.addEventListener(
						'touchend',
						function(e) {
							var pixelsMoved = $doc.touchStartX
									- e.changedTouches[0].pageX;
							var SWIPE_SIZE = 150;
							if (pixelsMoved > SWIPE_SIZE) {
								presentation.@com.excilys.formation.gwt.client.slider.slides.Presentation::displayNextSlide()();
							} else if (pixelsMoved < -SWIPE_SIZE) {
								presentation.@com.excilys.formation.gwt.client.slider.slides.Presentation::displayPreviousSlide()();
							}
						}, false);
    }-*/;

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();
        int slideNumber = parseSlideNumber(token);
        int chapterNumber = parseChapterNumber(token);

        displaySlide(chapterNumber, slideNumber);
    }

    private static int parseSlideNumber(String token) {
        String number = token.substring(token.indexOf(SLIDE_PREFIX) + SLIDE_PREFIX.length());
        // If parsing fails, go to first slide
        return parseIntOr1(number);
    }

    private static int parseChapterNumber(String token) {
        String number = token.substring(token.indexOf(CHAPTER_PREFIX) + CHAPTER_PREFIX.length(), token.indexOf(SLIDE_PREFIX));
        // If parsing fails, go to first chapter
        return parseIntOr1(number);
    }

    private static int parseIntOr1(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return 1;
        }
    }
}
