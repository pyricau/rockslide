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
package info.piwai.rockslide.client.shownotes;

import info.piwai.rockslide.client.Resources;
import info.piwai.rockslide.client.window.WindowHelper;
import info.piwai.rockslide.client.window.WindowMessageListener;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class ShowNotesViewer {

    public void load() {
        Window.setTitle("Show notes");
        Resources.instance.shownotes().ensureInjected();
        RootPanel rootPanel = RootPanel.get();
        final HTML html = new HTML();
        rootPanel.add(html);

        html.setHTML("<div>Waiting for show notes</div>");

        WindowHelper.registerListener(ShowNotesSender.LISTENER_NAME, new WindowMessageListener<String>() {
            @Override
            public void onMessage(String message) {
                html.setHTML(message);
            }
        });
        WindowHelper.sendMessage("childLoaded", null);
    }

}
