package info.piwai.cv.gwt.client.slider;

import info.piwai.cv.gwt.client.slider.shownotes.ShowNotesViewer;
import info.piwai.cv.gwt.client.slider.slides.SlideViewer;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window.Location;

public abstract class PresentationEntryPoint implements EntryPoint, PresentationBuilder {

    public static final String SHOW_NOTES_PARAM = "showNotes";

    @Override
    public void onModuleLoad() {
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
