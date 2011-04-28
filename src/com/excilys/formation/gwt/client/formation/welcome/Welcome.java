package com.excilys.formation.gwt.client.formation.welcome;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Welcome extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("BonneJournee.ui.xml")
    interface BonneJournee extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Auteurs.ui.xml")
    interface Auteurs extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("PosesDesQuestions.ui.xml")
    interface PosesDesQuestions extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Whoswho.ui.xml")
    interface Whoswho extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Presentation.ui.xml")
    interface Presentation extends UiBinder<Element, ElementSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Auteurs.class));
        addSlide(FormationGwt.PLAN);
        addSlide(GWT.create(PosesDesQuestions.class));
        addSlide(GWT.create(Whoswho.class));
        addSlide(GWT.create(Presentation.class));
        addSlide(GWT.create(BonneJournee.class));
        addSlide(FormationGwt.PLAN);
    }

}
