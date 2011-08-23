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

import info.piwai.rockslide.client.slides.Presentable;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Slide extends HTMLPanel implements Presentable {

    private String historyId = "Slide";
    
    private Element notes;

    public Slide(String html) {
        super(html);
    }

    @Override
    public Element getShowNotes() {
        return notes;
    }
    
    public String getHistoryName() {
        return historyId;
    }
    
    public void extractShowNotes() {
        com.google.gwt.user.client.Element element = getElement();
        int childCount = element.getChildCount();
        
        for (int i = 0; i< childCount; i++) {
            Node child = element.getChild(i);
            if ("NOTES".equals(child.getNodeName().toUpperCase())) {
                notes = Element.as(child);
                notes.removeFromParent();
                return;
            }
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

}
