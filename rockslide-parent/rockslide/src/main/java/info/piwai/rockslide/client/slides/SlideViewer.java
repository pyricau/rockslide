package info.piwai.rockslide.client.slides;

import info.piwai.rockslide.client.PresentationBuilder;
import info.piwai.rockslide.client.PresentationEntryPoint;
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

public class SlideViewer implements ValueChangeHandler<String>, ChapterHolder {

    public static final String TRAINER_PARAM = "trainer";

    public static final String SLIDE_PREFIX = "_";

    private Presentation presentation;

    private int currentChapter = -1;

    private final List<Chapter> chapters = new ArrayList<Chapter>();
    private final List<String> chapterNames = new ArrayList<String>();

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
                    + "dependent=true,"//
                    + "width=1200," //
                    + "height=600" //
            ;

            String showNotesUrl = Location.createUrlBuilder() //
                    .removeParameter(SlideViewer.TRAINER_PARAM) //
                    .setParameter(PresentationEntryPoint.SHOW_NOTES_PARAM, "true") //
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
        presentationBuilder.loadChapters(this);

        presentation = new Presentation(new ShowNotesSender(childWindow), presentationBuilder);
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

    @Override
    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
        String chapterName = chapter.getHistoryName();
        chapterName = chapterName.replace("_", "");
        String realChapterName;
        if (chapterNames.contains(chapterName)) {
            int i = 1;
            do {
                i++;
                realChapterName = chapterName + i;
            } while (chapterNames.contains(realChapterName));
        } else {
            realChapterName = chapterName;
        }
        chapterNames.add(realChapterName);
    }

    private void displayChapter(int chapterIndex) {
        displaySlide(chapterIndex, 0);
    }

    private void displaySlide(int chapterIndex, int slideIndex) {

        chapterIndex = checkChapterIndex(chapterIndex);
        if (chapterIndex != currentChapter) {
            currentChapter = chapterIndex;
            Chapter chapter = chapters.get(chapterIndex);
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
    public List<Chapter> getChapters() {
        return chapters;
    }
}
