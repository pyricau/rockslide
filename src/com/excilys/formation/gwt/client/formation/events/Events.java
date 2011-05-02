package com.excilys.formation.gwt.client.formation.events;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Events extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Principe.ui.xml")
    interface Principe extends UiBinder<Element, ElementSlide> {
        Principe binder = GWT.create(Principe.class);
    }

    @UiTemplate("CustomEvent.ui.xml")
    interface CustomEvent extends UiBinder<Widget, WidgetSlide> {
        CustomEvent binder = GWT.create(CustomEvent.class);
    }

    @UiTemplate("RegisterHandler.ui.xml")
    interface RegisterHandler extends UiBinder<Widget, WidgetSlide> {
        RegisterHandler binder = GWT.create(RegisterHandler.class);
    }

    @UiTemplate("EventBus.ui.xml")
    interface EventBus extends UiBinder<Widget, WidgetSlide> {
        EventBus binder = GWT.create(EventBus.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Titre.binder);
        addSlide(Principe.binder);
        addWidgetSlide(CustomEvent.binder);
        addWidgetSlide(RegisterHandler.binder);
        addWidgetSlide(EventBus.binder);
        addSlide(Plan.binder);
    }

}
