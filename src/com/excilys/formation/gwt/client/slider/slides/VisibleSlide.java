package com.excilys.formation.gwt.client.slider.slides;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class VisibleSlide extends WidgetSlide implements Presentable {

    @UiField
    public Visible visibleWidget;

    public VisibleSlide(UiBinder<Widget, Object> uiBinder) {
        super(uiBinder);
    }

    @Override
    public void visible() {
        visibleWidget.visible();
    }
}
