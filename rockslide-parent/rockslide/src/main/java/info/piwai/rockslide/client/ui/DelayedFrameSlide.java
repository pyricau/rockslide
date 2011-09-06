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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Frame;

public class DelayedFrameSlide extends Frame implements SlidePresentable {
	
    private String historyId = "Slide";

    public String url;

    private boolean visible = false;

    public DelayedFrameSlide() {
        super();
    }

    public DelayedFrameSlide(String url) {
        super(url);
    }

    protected DelayedFrameSlide(Element element) {
        super(element);
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void visible() {
        if (!visible && url != null) {
            visible = true;
            super.setUrl(url);
        }
    }

	@Override
	public Element getShowNotes() {
		return null;
	}

    @Override
    public String getHistoryName() {
        return historyId;
    }

	@Override
	public void transform() {
	}

}
