package com.excilys.formation.gwt.client.slider.slides;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class ElementSlide extends Widget implements Presentable {

    public ElementSlide(UiBinder<?, ?> uiBinder) {
        setElement(cast(uiBinder).createAndBindUi(this));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static UiBinder<Element, Object> cast(UiBinder uiBinder) {
        return uiBinder;
    }

    @Override
    public void visible() {
    }

    @Override
    public Element getShowNotes() {
        return null;
    }
}
