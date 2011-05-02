package com.excilys.formation.gwt.client.formation.outil_avances;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.excilys.formation.gwt.client.slider.slides.VisibleSlide;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class OutilsAvances extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Log.ui.xml")
    interface Log extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Liste.ui.xml")
    interface Liste extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Visualization.ui.xml")
    interface Visualization extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("ExtGWT.ui.xml")
    interface ExtGWT extends UiBinder<Widget, VisibleSlide> {}

    @UiTemplate("SmartGWT.ui.xml")
    interface SmartGWT extends UiBinder<Widget, VisibleSlide> {}

    @UiTemplate("GoogleGin.ui.xml")
    interface GoogleGin extends UiBinder<Widget, WidgetSlide> {}

    @UiTemplate("GwtDnd.ui.xml")
    interface GwtDnd extends UiBinder<Widget, VisibleSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Log.class));
        addSlide(GWT.create(Liste.class));
        addSlide(GWT.create(Visualization.class));
        addVisibleSlide(GWT.create(ExtGWT.class));
        addVisibleSlide(GWT.create(SmartGWT.class));
        addWidgetSlide(GWT.create(GoogleGin.class));
        addVisibleSlide(GWT.create(GwtDnd.class));
        addSlide(Plan.binder);
    }

}
