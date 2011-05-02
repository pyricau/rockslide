package com.excilys.formation.gwt.client.formation.clientbundle;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.shownotes.ElementSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class ClientBundle extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Principe.ui.xml")
    interface Principe extends UiBinder<Element, ElementSlide> {
        Principe binder = GWT.create(Principe.class);
    }

    @UiTemplate("Utilisation.ui.xml")
    interface Utilisation extends UiBinder<Widget, WidgetSlide> {
        Utilisation binder = GWT.create(Utilisation.class);
    }

    @UiTemplate("Asynchronous.ui.xml")
    interface Asynchronous extends UiBinder<Widget, WidgetSlide> {
        Asynchronous binder = GWT.create(Asynchronous.class);
    }

    @UiTemplate("I18N.ui.xml")
    interface I18N extends UiBinder<Widget, WidgetSlide> {
        I18N binder = GWT.create(I18N.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addSlide(Principe.binder);
        addWidgetSlide(Utilisation.binder);
        addWidgetSlide(Asynchronous.binder);
        addWidgetSlide(I18N.binder);
        addSlide(Plan.binder);
    }

}
