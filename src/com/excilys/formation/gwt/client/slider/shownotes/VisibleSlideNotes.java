package com.excilys.formation.gwt.client.slider.shownotes;

import com.excilys.formation.gwt.client.slider.slides.Presentable;
import com.excilys.formation.gwt.client.slider.slides.VisibleSlide;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

public class VisibleSlideNotes extends VisibleSlide implements Presentable {

    @UiField
    public Element notes;

    public VisibleSlideNotes(UiBinder<?, ?> uiBinder) {
        super(uiBinder);
        notes.removeFromParent();
    }

    @Override
    public Element getShowNotes() {
        return notes;
    }
}
