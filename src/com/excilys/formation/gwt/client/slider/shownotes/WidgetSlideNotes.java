package com.excilys.formation.gwt.client.slider.shownotes;

import com.excilys.formation.gwt.client.slider.slides.Presentable;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class WidgetSlideNotes extends WidgetSlide implements Presentable {

    @UiField
    public Element notes;

    public WidgetSlideNotes(UiBinder<Widget, Object> uiBinder) {
        super(uiBinder);
        notes.removeFromParent();
    }

    @Override
    public Element getShowNotes() {
        return notes;
    }
}
