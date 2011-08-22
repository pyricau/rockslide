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
                showNotesHTML = "<div>No show notes for this slide.</div>";
            }

            childWindow.sendMessage(LISTENER_NAME, showNotesHTML);
        }
    }

}
