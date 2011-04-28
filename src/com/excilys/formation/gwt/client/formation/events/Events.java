package com.excilys.formation.gwt.client.formation.events;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.excilys.formation.gwt.client.slider.WidgetSlide;
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
    interface CustomEvent extends UiBinder<Widget, WidgetSlide> {}

    @UiTemplate("RegisterHandler.ui.xml")
    interface RegisterHandler extends UiBinder<Widget, WidgetSlide> {}

    @UiTemplate("EventBus.ui.xml")
    interface EventBus extends UiBinder<Widget, WidgetSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Principe.class));
        addWidgetSlide(GWT.create(CustomEvent.class));
        addWidgetSlide(GWT.create(RegisterHandler.class));
        addWidgetSlide(GWT.create(EventBus.class));
        addSlide(FormationGwt.PLAN);
    }

}
