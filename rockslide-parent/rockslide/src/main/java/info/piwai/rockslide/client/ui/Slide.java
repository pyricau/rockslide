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
package info.piwai.rockslide.client.ui;

import info.piwai.rockslide.client.slides.SlidePresentable;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Slide extends HTMLPanel implements SlidePresentable {

    private String historyId = "MDSlide";

    private Element notes;

    private boolean intro = false;

    public Slide(String html) {
        super(html);
    }

    @Override
    public Element getShowNotes() {
        return notes;
    }

    @Override
    public String getHistoryName() {
        return historyId;
    }

    @Override
    public void transform() {
        com.google.gwt.user.client.Element element = getElement();
        int childCount = element.getChildCount();

        for (int i = 0; i < childCount; i++) {
            Node child = element.getChild(i);
            if ("NOTES".equals(child.getNodeName().toUpperCase())) {
                notes = Element.as(child);
                notes.removeFromParent();
                break;
            }
        }

        
        
        if (intro == true) {
            com.google.gwt.user.client.Element introDiv = DOM.createDiv();
            introDiv.addClassName("intro");
            
            childCount = element.getChildCount();
            
            for (int i = 0; i < childCount; i++) {
                Node child = element.getFirstChild();
                introDiv.appendChild(child);
            }
            
            element.appendChild(introDiv);
        }
    }

    /**
     * May be overridden
     */
    @Override
    public void visible() {
    }

    public void setHid(String historyId) {
        historyId = historyId.trim();
        if (!"".equals(historyId)) {
            this.historyId = historyId;
        }
    }

    public void setIntro(boolean intro) {
        this.intro = intro;
    }

}
