package com.excilys.formation.gwt.client.formation.uibinder;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.shownotes.WidgetSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class UIBinder extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("WithoutUiBinder.ui.xml")
    interface WithoutUiBinder extends UiBinder<Widget, WidgetSlideNotes> {
        WithoutUiBinder binder = GWT.create(WithoutUiBinder.class);
    }

    @UiTemplate("Solution.ui.xml")
    interface Solution extends UiBinder<Element, ElementSlide> {
        Solution binder = GWT.create(Solution.class);
    }

    @UiTemplate("UI.ui.xml")
    interface UI extends UiBinder<Element, ElementSlide> {
        UI binder = GWT.create(UI.class);
    }

    @UiTemplate("HtmlCssJs.ui.xml")
    interface HtmlCssJs extends UiBinder<Widget, WidgetSlideNotes> {
        HtmlCssJs binder = GWT.create(HtmlCssJs.class);
    }

    @UiTemplate("XmlBinder.ui.xml")
    interface XmlBinder extends UiBinder<Widget, WidgetSlideNotes> {
        XmlBinder binder = GWT.create(XmlBinder.class);
    }

    @UiTemplate("JavaBinder.ui.xml")
    interface JavaBinder extends UiBinder<Widget, WidgetSlideNotes> {
        JavaBinder binder = GWT.create(JavaBinder.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Titre.binder);
        addWidgetNotesSlide(WithoutUiBinder.binder);
        addSlide(Solution.binder);
        addSlide(UI.binder);
        addWidgetNotesSlide(HtmlCssJs.binder);
        addWidgetNotesSlide(XmlBinder.binder);
        addWidgetNotesSlide(JavaBinder.binder);
        addSlide(Plan.binder);
    }

}
