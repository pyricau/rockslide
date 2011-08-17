package info.piwai.rockslide.client.shownotes;

import info.piwai.rockslide.client.slides.Presentable;
import info.piwai.rockslide.client.window.ChildWindow;

import com.google.gwt.dom.client.Element;

public class ShowNotesSender {

    public static final String LISTENER_NAME = "showNotes";

    private final ChildWindow childWindow;

    public ShowNotesSender(ChildWindow childWindow) {
        this.childWindow = childWindow;
    }

    public void sendShowNotes(Presentable slide) {
        if (slide != null && childWindow != null) {
            Element showNotesWidget = slide.getShowNotes();
            String showNotesHTML;
            if (showNotesWidget != null) {
                showNotesHTML = showNotesWidget.getInnerHTML();
            } else {
                showNotesHTML = "<div>Pas de notes</div>";
            }

            childWindow.sendMessage(LISTENER_NAME, showNotesHTML);
        }
    }

}
