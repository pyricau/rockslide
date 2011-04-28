package com.excilys.formation.gwt.client.slider.window;

import com.excilys.formation.gwt.client.slider.Presentable;
import com.google.gwt.dom.client.Element;

public class ShowNotesSender {

    public static final String LISTENER_NAME = "showNotes";

    private final ChildWindow childWindow;

    public ShowNotesSender(ChildWindow childWindow) {
        this.childWindow = childWindow;
    }

    public void sendShowNotes(Presentable slide) {
        if (childWindow != null) {
            Element showNotesWidget = slide.getShowNotes();
            if (showNotesWidget != null) {
                childWindow.sendMessage(LISTENER_NAME, showNotesWidget.getInnerHTML());
            }

        }
    }

}
