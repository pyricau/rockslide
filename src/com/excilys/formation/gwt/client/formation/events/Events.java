package com.excilys.formation.gwt.client.formation.events;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.CodeSlide;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Events extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Principe.ui.xml")
    interface Principe extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("CustomEvent.ui.xml")
    interface CustomEvent extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("RegisterHandler.ui.xml")
    interface RegisterHandler extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("EventBus.ui.xml")
    interface EventBus extends UiBinder<Widget, CodeSlide<?>> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Principe.class));
        addCodeSlide(GWT.create(CustomEvent.class));
        addCodeSlide(GWT.create(RegisterHandler.class));
        addCodeSlide(GWT.create(EventBus.class));
        addSlide(FormationGwt.PLAN);
    }

}
