package com.excilys.formation.gwt.client.formation.clientbundle;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class ClientBundle extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(FormationGwt.PLAN);
    }

}
