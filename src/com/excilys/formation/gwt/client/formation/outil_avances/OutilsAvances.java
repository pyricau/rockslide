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
    interface Titre extends UiBinder<Element, ElementSlide> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Log.ui.xml")
    interface Log extends UiBinder<Element, ElementSlide> {
        Log binder = GWT.create(Log.class);
    }

    @UiTemplate("Liste.ui.xml")
    interface Liste extends UiBinder<Element, ElementSlide> {
        Liste binder = GWT.create(Liste.class);
    }

    @UiTemplate("Visualization.ui.xml")
    interface Visualization extends UiBinder<Element, ElementSlide> {
        Visualization binder = GWT.create(Visualization.class);
    }

    @UiTemplate("ExtGWT.ui.xml")
    interface ExtGWT extends UiBinder<Widget, VisibleSlide> {
        ExtGWT binder = GWT.create(ExtGWT.class);
    }

    @UiTemplate("SmartGWT.ui.xml")
    interface SmartGWT extends UiBinder<Widget, VisibleSlide> {
        SmartGWT binder = GWT.create(SmartGWT.class);
    }

    @UiTemplate("GoogleGin.ui.xml")
    interface GoogleGin extends UiBinder<Widget, WidgetSlide> {
        GoogleGin binder = GWT.create(GoogleGin.class);
    }

    @UiTemplate("GwtDnd.ui.xml")
    interface GwtDnd extends UiBinder<Widget, VisibleSlide> {
        GwtDnd binder = GWT.create(GwtDnd.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Titre.binder);
        addSlide(Log.binder);
        addSlide(Liste.binder);
        addSlide(Visualization.binder);
        addVisibleSlide(ExtGWT.binder);
        addVisibleSlide(SmartGWT.binder);
        addWidgetSlide(GoogleGin.binder);
        addVisibleSlide(GwtDnd.binder);
        addSlide(Plan.binder);
    }

}
