package com.excilys.formation.gwt.client.formation.welcome;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Welcome extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("BonneJournee.ui.xml")
    interface BonneJournee extends UiBinder<Element, ElementSlide> {
        BonneJournee binder = GWT.create(BonneJournee.class);
    }

    @UiTemplate("Auteurs.ui.xml")
    interface Auteurs extends UiBinder<Element, ElementSlide> {
        Auteurs binder = GWT.create(Auteurs.class);
    }

    @UiTemplate("PosesDesQuestions.ui.xml")
    interface PosesDesQuestions extends UiBinder<Element, ElementSlide> {
        PosesDesQuestions binder = GWT.create(PosesDesQuestions.class);
    }

    @UiTemplate("Whoswho.ui.xml")
    interface Whoswho extends UiBinder<Element, ElementSlide> {
        Whoswho binder = GWT.create(Whoswho.class);
    }

    @UiTemplate("Presentation.ui.xml")
    interface Presentation extends UiBinder<Element, ElementSlide> {
        Presentation binder = GWT.create(Presentation.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Titre.binder);
        addSlide(Auteurs.binder);
        addSlide(Plan.binder);
        addSlide(PosesDesQuestions.binder);
        addSlide(Whoswho.binder);
        addSlide(Presentation.binder);
        addSlide(BonneJournee.binder);
        addSlide(Plan.binder);
    }

}
