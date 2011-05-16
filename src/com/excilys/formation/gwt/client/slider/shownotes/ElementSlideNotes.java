package com.excilys.formation.gwt.client.slider.shownotes;

import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

public class ElementSlideNotes extends ElementSlide {

    @UiField
    public Element notes;

    public ElementSlideNotes(UiBinder<?, ?> uiBinder) {
        super(uiBinder);
        notes.removeFromParent();
    }

    @Override
    public Element getShowNotes() {
        return notes;
    }
}
