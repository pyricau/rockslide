package com.excilys.formation.gwt.client.formation.environnement_dev;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.shownotes.ElementSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class EnvironnementDev extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("GWTDesigner.ui.xml")
    interface GWTDesigner extends UiBinder<Element, ElementSlideNotes> {
        GWTDesigner binder = GWT.create(GWTDesigner.class);
    }

    @UiTemplate("SpeedTracer.ui.xml")
    interface SpeedTracer extends UiBinder<Element, ElementSlideNotes> {
        SpeedTracer binder = GWT.create(SpeedTracer.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(GWTDesigner.binder);
        addNotesSlide(SpeedTracer.binder);
        addSlide(Plan.binder);
    }

}
