package com.excilys.formation.gwt.client.slider.slides;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class ElementSlide extends Widget implements Presentable {

    public ElementSlide(UiBinder<Element, Object> uiBinder) {
        setElement(uiBinder.createAndBindUi(this));
    }

    @Override
    public void visible() {
    }

    @Override
    public Element getShowNotes() {
        return null;
    }
}
