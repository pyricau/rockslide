package com.excilys.formation.gwt.client.slider;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class VisibleSlideNotes extends VisibleSlide implements Presentable {

    @UiField
    public Element notes;

    public VisibleSlideNotes(UiBinder<Widget, Object> uiBinder) {
        super(uiBinder);
        notes.removeFromParent();
    }

    @Override
    public Element getShowNotes() {
        return notes;
    }
}
