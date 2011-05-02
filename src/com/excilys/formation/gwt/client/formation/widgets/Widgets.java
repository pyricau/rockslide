package com.excilys.formation.gwt.client.formation.widgets;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.shownotes.ElementSlideNotes;
import com.excilys.formation.gwt.client.slider.shownotes.WidgetSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.VisibleSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Widgets extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Presentation.ui.xml")
    interface Presentation extends UiBinder<Element, ElementSlideNotes> {
        Presentation binder = GWT.create(Presentation.class);
    }

    @UiTemplate("WidgetsGWT.ui.xml")
    interface WidgetsGWT extends UiBinder<Element, ElementSlideNotes> {
        WidgetsGWT binder = GWT.create(WidgetsGWT.class);
    }

    @UiTemplate("Showcase.ui.xml")
    interface Showcase extends UiBinder<Widget, VisibleSlide> {
        Showcase binder = GWT.create(Showcase.class);
    }

    @UiTemplate("Composite.ui.xml")
    interface Composite extends UiBinder<Widget, WidgetSlideNotes> {
        Composite binder = GWT.create(Composite.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(Presentation.binder);
        addNotesSlide(WidgetsGWT.binder);
        addVisibleSlide(Showcase.binder);
        addWidgetNotesSlide(Composite.binder);
        addSlide(Plan.binder);
    }

}
