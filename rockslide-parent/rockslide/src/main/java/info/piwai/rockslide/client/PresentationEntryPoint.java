package info.piwai.rockslide.client;

import info.piwai.rockslide.client.shownotes.ShowNotesViewer;
import info.piwai.rockslide.client.slides.SlideViewer;

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
            GWT.runAsync(new RunAsyncCallback() {
                public void onFailure(Throwable caught) {
                    Window.alert("Error: could not download shownotes code");
                }

                public void onSuccess() {
                    initNotes();
                    ShowNotesViewer showNotesViewer = new ShowNotesViewer();
                    showNotesViewer.load();
                }
            });
        } else {
            GWT.runAsync(new RunAsyncCallback() {
                public void onFailure(Throwable caught) {
                    Window.alert("Error: could not download slides code");
                }

                public void onSuccess() {
                    initSlides();
                    SlideViewer slideViewer = new SlideViewer(PresentationEntryPoint.this);
                    slideViewer.load();
                }
            });

        }
    }
    
    @Override
    public IsWidget getHeaderWidget() {
        return null;
    }
    
}
