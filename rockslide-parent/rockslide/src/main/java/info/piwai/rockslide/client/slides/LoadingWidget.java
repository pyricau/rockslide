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
package info.piwai.rockslide.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class LoadingWidget extends Widget {

    private static Binder uiBinder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Element, LoadingWidget> {}

    interface Style extends CssResource {
        String hidden();
    }

    @UiField
    Style style;

    @UiField
    DivElement slowLoading;

    public LoadingWidget() {
        setElement(uiBinder.createAndBindUi(this));
    }

    public void showSlowLoadingWarning() {
        slowLoading.removeClassName(style.hidden());
    }
}
