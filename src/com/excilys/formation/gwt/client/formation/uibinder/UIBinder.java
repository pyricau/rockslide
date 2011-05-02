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
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("WithoutUiBinder.ui.xml")
    interface WithoutUiBinder extends UiBinder<Widget, WidgetSlideNotes> {}

    @UiTemplate("Solution.ui.xml")
    interface Solution extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("UI.ui.xml")
    interface UI extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("HtmlCssJs.ui.xml")
    interface HtmlCssJs extends UiBinder<Widget, WidgetSlideNotes> {}

    @UiTemplate("XmlBinder.ui.xml")
    interface XmlBinder extends UiBinder<Widget, WidgetSlideNotes> {}

    @UiTemplate("JavaBinder.ui.xml")
    interface JavaBinder extends UiBinder<Widget, WidgetSlideNotes> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addWidgetNotesSlide(GWT.create(WithoutUiBinder.class));
        addSlide(GWT.create(Solution.class));
        addSlide(GWT.create(UI.class));
        addWidgetNotesSlide(GWT.create(HtmlCssJs.class));
        addWidgetNotesSlide(GWT.create(XmlBinder.class));
        addWidgetNotesSlide(GWT.create(JavaBinder.class));
        addSlide(Plan.binder);
    }

}
