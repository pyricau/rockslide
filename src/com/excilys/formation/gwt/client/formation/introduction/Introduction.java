package com.excilys.formation.gwt.client.formation.introduction;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Introduction extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("AQuoi.ui.xml")
    interface AQuoi extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Fonctionnement.ui.xml")
    interface Fonctionnement extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Compilation.ui.xml")
    interface Compilation extends UiBinder<Element, ElementSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(Titre.binder);
        addSlide(GWT.create(AQuoi.class));
        addSlide(GWT.create(Fonctionnement.class));
        addSlide(GWT.create(Compilation.class));
        addPresentable(new TropSimple());
        addSlide(Plan.binder);
    }

}
