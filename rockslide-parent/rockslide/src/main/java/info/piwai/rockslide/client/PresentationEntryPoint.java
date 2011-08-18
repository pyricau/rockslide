package info.piwai.rockslide.client;

import info.piwai.rockslide.client.shownotes.ShowNotesViewer;
import info.piwai.rockslide.client.slides.SlideViewer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window.Location;

public abstract class PresentationEntryPoint implements EntryPoint, PresentationBuilder {

    public static final String SHOW_NOTES_PARAM = "showNotes";
    
    public void init() {
    }

    @Override
    public final void onModuleLoad() {
        
        init();
        
        // TODO add a split point ? Or maybe use two different entry points ?
        String showNotes = Location.getParameter(SHOW_NOTES_PARAM);
        if ("true".equals(showNotes)) {
            ShowNotesViewer showNotesViewer = new ShowNotesViewer();
            showNotesViewer.load();
        } else {
            SlideViewer slideViewer = new SlideViewer(this);
            slideViewer.load();
        }
    }
}
