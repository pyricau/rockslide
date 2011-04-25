package com.excilys.formation.gwt.client.slider;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public abstract class SlideViewer implements EntryPoint, ValueChangeHandler<String> {

    public static final String CHAPTER_PREFIX = "chapter";
    public static final String SLIDE_PREFIX = "slide";

    private Presentation presentation;

    private int currentChapter;

    private final List<Chapter> chapters = new ArrayList<Chapter>();

    @Override
    public void onModuleLoad() {
        // To ensure the uncaughtexceptionhandler is registered, loading must be
        // done in a deferred command
        Scheduler.get().scheduleDeferred(new Command() {

            @Override
            public void execute() {
                doModuleLoad();
            }
        });
    }

    private void doModuleLoad() {
        Resources.instance.main().ensureInjected();
        loadChapters();
        presentation = new Presentation();
        RootPanel.get().add(presentation);
        initializeHistory();
        registerDocumentEvent(presentation);
    }

    protected void add(Chapter chapter) {
        chapters.add(chapter);
    }

    protected abstract void loadChapters();

    private void displayChapter(int chapterIndex) {
        displaySlide(chapterIndex, 1);
    }

    private void displaySlide(int chapterIndex, int slideIndex) {
        if (chapterIndex < 1) {
            chapterIndex = 1;
        } else if (chapterIndex > chapters.size()) {
            chapterIndex = chapters.size();
        }
        if (chapterIndex != currentChapter) {
            currentChapter = chapterIndex;
            Chapter chapter = chapters.get(chapterIndex - 1);
            presentation.updateSlides(chapterIndex, chapter.getSlides());
        }
        presentation.displaySlide(slideIndex);
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
				presentation.@com.excilys.formation.gwt.client.slider.Presentation::displayPreviousSlide()();
				break;
			case 39: // right arrow
				presentation.@com.excilys.formation.gwt.client.slider.Presentation::displayNextSlide()();
				break;
			case 51: // 3
				presentation.@com.excilys.formation.gwt.client.slider.Presentation::switch3D()();
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
								presentation.@com.excilys.formation.gwt.client.slider.Presentation::displayNextSlide()();
							} else if (pixelsMoved < -SWIPE_SIZE) {
								presentation.@com.excilys.formation.gwt.client.slider.Presentation::displayPreviousSlide()();
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

    protected static int parseSlideNumber(String token) {
        try {
            String number = token.substring(token.indexOf(SLIDE_PREFIX) + SLIDE_PREFIX.length());
            return Integer.parseInt(number);
        } catch (Exception e) {
            // If parsing fails, go to first slide
            return 1;
        }
    }

    protected static int parseChapterNumber(String token) {
        try {
            String number = token.substring(CHAPTER_PREFIX.length(), token.indexOf(SLIDE_PREFIX));
            return Integer.parseInt(number);
        } catch (Exception e) {
            // If parsing fails, go to first chapter
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(parseChapterNumber("chapter2slide3"));
        System.out.println(parseSlideNumber("chapter2slide3"));
    }

}
