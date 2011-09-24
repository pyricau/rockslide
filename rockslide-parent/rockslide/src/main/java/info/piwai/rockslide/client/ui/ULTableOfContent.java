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

import info.piwai.rockslide.client.slides.ChapterName;
import info.piwai.rockslide.client.slides.SlidePresentable;
import info.piwai.rockslide.client.slides.TableOfContent;
import info.piwai.rockslide.client.slides.ULPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ULTableOfContent extends Composite implements SlidePresentable{

    interface Binder extends UiBinder<Widget, ULTableOfContent> {
    }

    private static final Binder binder = GWT.create(Binder.class);
    
    private String historyId = "TableOfContents";
    
    @UiField
    ULPanel ulPanel;

    public ULTableOfContent() {
    	initWidget(binder.createAndBindUi(this));
    }
    
	@Override
	public String getHistoryName() {
		return historyId;
	}

	@Override
	public void init(TableOfContent tableOfContent) {
        for (ChapterName chapterName : tableOfContent.getChapterNames()) {
            String readableName = chapterName.getReadableName();
            String historyName = chapterName.getHistoryName();

            Anchor anchor = new Anchor(readableName);
            anchor.setHref("#" + historyName);

            ulPanel.add(anchor);
        }
	}
	
    public void setHid(String historyId) {
        historyId = historyId.trim();
        if (!"".equals(historyId)) {
            this.historyId = historyId;
        }
    }

	@Override
	public Element getShowNotes() {
		return null;
	}

	@Override
	public void visible() {
	}
}
