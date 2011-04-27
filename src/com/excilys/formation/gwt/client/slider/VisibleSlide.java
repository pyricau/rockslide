package com.excilys.formation.gwt.client.slider;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class VisibleSlide extends Composite implements Presentable {

    @UiField
    public Presentable visibleWidget;

    public VisibleSlide(UiBinder<Widget, VisibleSlide> uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void visible() {
        visibleWidget.visible();
    }
}
