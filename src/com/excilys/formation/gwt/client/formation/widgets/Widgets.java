package com.excilys.formation.gwt.client.formation.widgets;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.excilys.formation.gwt.client.slider.VisibleSlide;
import com.excilys.formation.gwt.client.slider.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Widgets extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Presentation.ui.xml")
    interface Presentation extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("WidgetsGWT.ui.xml")
    interface WidgetsGWT extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Showcase.ui.xml")
    interface Showcase extends UiBinder<Widget, VisibleSlide> {}

    @UiTemplate("Composite.ui.xml")
    interface Composite extends UiBinder<Widget, WidgetSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Presentation.class));
        addSlide(GWT.create(WidgetsGWT.class));
        addVisibleSlide(GWT.create(Showcase.class));
        addWidgetSlide(GWT.create(Composite.class));
        addSlide(FormationGwt.PLAN);
    }

}
