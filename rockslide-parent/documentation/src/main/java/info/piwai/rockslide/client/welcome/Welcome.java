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
package info.piwai.rockslide.client.welcome;

import info.piwai.rockslide.client.slides.Chapter;
import info.piwai.rockslide.client.slides.ElementSlide;
import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Welcome extends Chapter {

    @UiTemplate("Hello.ui.xml")
    interface Hello extends UiBinder<Element, ElementSlide> {
        Hello binder = GWT.create(Hello.class);
    }

    @UiTemplate("CreateYours.ui.xml")
    interface CreateYours extends UiBinder<Widget, WidgetSlide> {
        CreateYours binder = GWT.create(CreateYours.class);
    }

    @UiTemplate("Intro.ui.xml")
    interface Intro extends UiBinder<Widget, WidgetSlide> {
        Intro binder = GWT.create(Intro.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Hello.binder);
        addWidgetSlide(Intro.binder);
        addWidgetSlide(CreateYours.binder);
        addTableOfContent();
    }
}
