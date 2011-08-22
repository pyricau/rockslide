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
package info.piwai.rockslide.client.features;

import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class ClassicGWT extends WidgetSlide {


    interface Binder extends UiBinder<Widget, ClassicGWT> {
        Binder binder = GWT.create(Binder.class);
    }

    public ClassicGWT() {
        super(Binder.binder);
    }

    @UiHandler("button")
    void clicked(ClickEvent e) {

        DialogBox dialogBox = new DialogBox();
        DialogBoxContent content = new DialogBoxContent(dialogBox);
        dialogBox.setWidget(content);
        dialogBox.setText("I can haz popups?");
        dialogBox.setAutoHideEnabled(false);
        dialogBox.setAnimationEnabled(true);
        dialogBox.setAutoHideOnHistoryEventsEnabled(true);
        dialogBox.setGlassEnabled(true);
        
        dialogBox.center();
    }

}
