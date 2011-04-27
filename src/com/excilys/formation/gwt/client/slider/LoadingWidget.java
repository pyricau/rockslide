package com.excilys.formation.gwt.client.slider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class LoadingWidget extends Widget {

    private static Binder uiBinder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Element, LoadingWidget> {}

    public LoadingWidget() {
        setElement(uiBinder.createAndBindUi(this));
    }
}
