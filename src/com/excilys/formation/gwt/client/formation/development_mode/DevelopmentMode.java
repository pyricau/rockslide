package com.excilys.formation.gwt.client.formation.development_mode;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class DevelopmentMode extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Indispensable.ui.xml")
    interface Indispensable extends UiBinder<Element, ElementSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Indispensable.class));
        addSlide(Plan.binder);
    }

}
