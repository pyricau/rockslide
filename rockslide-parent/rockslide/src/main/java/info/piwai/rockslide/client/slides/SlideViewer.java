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

import info.piwai.rockslide.client.PresentationBuilder;
import info.piwai.rockslide.client.Resources;
import info.piwai.rockslide.client.shownotes.ShowNotesSender;
import info.piwai.rockslide.client.window.ChildWindow;
import info.piwai.rockslide.client.window.WindowMessageListener;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.RootPanel;

public class SlideViewer implements ValueChangeHandler<String>, TableOfContent {

    public static final String TRAINER_PARAM = "trainer";

    public static final String SLIDE_PREFIX = "_";

    private Presentation presentation;

    private int currentChapter = -1;

    private final List<Chapter> chapters = new ArrayList<Chapter>();
    private final List<String> chapterNames = new ArrayList<String>();

    private ChildWindow childWindow;

    private LoadingWidget loadingWidget;

    private List<ChapterName> chapterNamesHolder = new ArrayList<ChapterName>();

	private HeaderWidget header;

    public SlideViewer() {
    }

    public void load(List<Chapter> chapters, HeaderWidget header) {
    	this.header = header;
		this.chapters.addAll(chapters);
    	
    	
        startLoading();
        if ("true".equals(Location.getParameter(SlideViewer.TRAINER_PARAM))) {
            String features = "menubar=no," //
                    + "location=false," //
                    + "resizable=yes," //
                    + "scrollbars=yes," //
                    + "status=no," //
                    + "dependent=true,"//
                    + "width=1200," //
                    + "height=600" //
            ;

            String showNotesUrl = Location.createUrlBuilder() //
                    .removeParameter(SlideViewer.TRAINER_PARAM) //
                    .setParameter(PresentationBuilder.SHOW_NOTES_PARAM, "true") //
                    .setHash(null) //
                    .buildString();
            childWindow = ChildWindow.open(showNotesUrl, "_blank", features);
            childWindow.registerListener("childLoaded", new WindowMessageListener<Void>() {
                @Override
                public void onMessage(Void message) {
                    loadSlideModule();
                }
            });
        } else {
            loadSlideModule();
        }
    }

    private void startLoading() {
        loadingWidget = new LoadingWidget();
        RootPanel.get().add(loadingWidget);
        Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {

            @Override
            public boolean execute() {
                if (loadingWidget != null) {
                    loadingWidget.showSlowLoadingWarning();
                }
                return false;
            }
        }, 3000);
    }

    private void stopLoading() {
        loadingWidget.removeFromParent();
        loadingWidget = null;
    }

    private void loadSlideModule() {
        Resources.instance.slides().ensureInjected();
        
        loadChapters();
        
        header.init(this);
        
        presentation = new Presentation(new ShowNotesSender(childWindow), header);
        stopLoading();
        RootPanel rootPanel = RootPanel.get();
        rootPanel.add(presentation);
        initializeHistory();
        Event.addNativePreviewHandler(new NativePreviewHandler() {
            @Override
            public void onPreviewNativeEvent(NativePreviewEvent event) {
                NativeEvent nativeEvent = event.getNativeEvent();
                if ("keydown".equals(nativeEvent.getType())) {
                    int keyCode = nativeEvent.getKeyCode();
                    switch (keyCode) {
                    case KeyCodes.KEY_LEFT:
                        presentation.displayPreviousSlide();
                        break;
                    case KeyCodes.KEY_RIGHT:
                        presentation.displayNextSlide();
                        break;
                    }
                }
            }
        });
    }

    private void loadChapters() {
    	for(Chapter chapter : chapters) {
		    String historyName = chapter.getHistoryName();
		    historyName = historyName.replace("_", "");
		    String finalHistoryName;
		    if (chapterNames.contains(historyName)) {
		        int i = 1;
		        do {
		            i++;
		            finalHistoryName = historyName + i;
		        } while (chapterNames.contains(finalHistoryName));
		    } else {
		        finalHistoryName = historyName;
		    }
		    chapterNames.add(finalHistoryName);
		    chapterNamesHolder.add(new ChapterName(finalHistoryName, chapter.getReadableName()));
    	}
    }

    private void displayChapter(int chapterIndex) {
        displaySlide(chapterIndex, 0);
    }

    private void displaySlide(int chapterIndex, int slideIndex) {

        chapterIndex = checkChapterIndex(chapterIndex);
        if (chapterIndex != currentChapter) {
            currentChapter = chapterIndex;
            Chapter chapter = chapters.get(chapterIndex);
            chapter.loadSlides(this);
            String chapterName = chapterNames.get(currentChapter);
            presentation.updateSlides(chapterName, chapter);
        }
        presentation.displaySlide(slideIndex);
    }

    private int checkChapterIndex(int chapterIndex) {
        if (chapterIndex < 0) {
            chapterIndex = 0;
        } else if (chapterIndex >= chapters.size()) {
            chapterIndex = chapters.size() - 1;
        }
        return chapterIndex;
    }

    private void initializeHistory() {
        History.addValueChangeHandler(this);
        if ("".equals(History.getToken())) {
            displayChapter(0);
        } else {
            History.fireCurrentHistoryState();
        }
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        Analytics.trackModuleRelativePageView(token);

        String chapterName = parseChapterName(token);

        int chapterIndex = chapterNames.indexOf(chapterName);

        if (chapterIndex == -1) {
            chapterIndex = 0;
        }

        Chapter chapter = chapters.get(chapterIndex);

        String slideName = parseSlideName(token);

        int slideIndex = chapter.getSlideIndex(slideName);

        displaySlide(chapterIndex, slideIndex);
    }

    private static String parseSlideName(String token) {
        int slidePrefixIndex = token.indexOf(SLIDE_PREFIX);
        if (slidePrefixIndex != -1) {
            return token.substring(slidePrefixIndex + SLIDE_PREFIX.length());
        } else {
            return "";
        }

    }

    private static String parseChapterName(String token) {
        int slidePrefixIndex = token.indexOf(SLIDE_PREFIX);
        if (slidePrefixIndex != -1) {
            return token.substring(0, slidePrefixIndex);
        } else {
            return token;
        }
    }

    @Override
    public List<ChapterName> getChapterNames() {
        return chapterNamesHolder ;
    }

}
