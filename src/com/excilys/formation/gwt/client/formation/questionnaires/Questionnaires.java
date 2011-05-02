package com.excilys.formation.gwt.client.formation.questionnaires;

import com.excilys.formation.gwt.client.slider.shownotes.ElementSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Questionnaires extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
    }

}
