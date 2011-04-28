package com.excilys.formation.gwt.client.slider.slides;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class WidgetSlide extends Composite implements Presentable {

    public WidgetSlide(UiBinder<Widget, Object> uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void visible() {
    }

    @Override
    public Element getShowNotes() {
        return null;
    }
}
