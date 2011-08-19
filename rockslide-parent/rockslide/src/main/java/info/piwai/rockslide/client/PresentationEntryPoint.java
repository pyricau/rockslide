package info.piwai.rockslide.client;

import info.piwai.rockslide.client.shownotes.ShowNotesViewer;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.TableOfContentFactory;
import info.piwai.rockslide.client.slides.SlideViewer;
import info.piwai.rockslide.client.slides.UlTableOfContentFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.IsWidget;

public abstract class PresentationEntryPoint implements EntryPoint, PresentationBuilder {

    public static final String SHOW_NOTES_PARAM = "showNotes";

    public void initSlides() {
    }

    public void initNotes() {
    }

    @Override
    public final void onModuleLoad() {
        String showNotes = Location.getParameter(SHOW_NOTES_PARAM);
        if ("true".equals(showNotes)) {
            initNotes();
            ShowNotesViewer showNotesViewer = new ShowNotesViewer();
            showNotesViewer.load();
        } else {
            initSlides();
            SlideViewer slideViewer = new SlideViewer(PresentationEntryPoint.this);
            slideViewer.load();
        }
    }

    @Override
    public IsWidget getHeaderWidget() {
        return null;
    }

    /**
     * May be overriden to provide other implementations of
     * PresentationMapFactory
     */
    @Override
    public TableOfContentFactory buildTableOfContentFactory(ChapterHolder chapterHolder) {
        return new UlTableOfContentFactory(chapterHolder);
    }

}
