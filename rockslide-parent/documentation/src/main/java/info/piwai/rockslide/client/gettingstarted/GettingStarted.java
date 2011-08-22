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
package info.piwai.rockslide.client.gettingstarted;

import info.piwai.rockslide.client.slides.Chapter;
import info.piwai.rockslide.client.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class GettingStarted extends Chapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }
    
    @UiTemplate("DIY.ui.xml")
    interface DIY extends UiBinder<Element, ElementSlide> {
        DIY binder = GWT.create(DIY.class);
    }


    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(DIY.binder);
        addTableOfContent();
    }
    
    @Override
    public String getReadableName() {
        return "Getting Started";
    }
}
