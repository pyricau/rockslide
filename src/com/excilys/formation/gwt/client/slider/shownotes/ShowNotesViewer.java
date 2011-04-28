package com.excilys.formation.gwt.client.slider.shownotes;

import com.excilys.formation.gwt.client.slider.window.WindowHelper;
import com.excilys.formation.gwt.client.slider.window.WindowMessageListener;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class ShowNotesViewer {

    public void load() {
        RootPanel rootPanel = RootPanel.get();
        final HTML html = new HTML();
        rootPanel.add(html);

        WindowHelper.registerListener(ShowNotesSender.LISTENER_NAME, new WindowMessageListener<String>() {
            @Override
            public void onMessage(String message) {
                html.setHTML(message);
            }
        });
        WindowHelper.sendMessage("childLoaded", null);
    }

}
