package com.excilys.formation.gwt.client.formation.uibinder;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.CodeSlide;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class UIBinder extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("WithoutUiBinder.ui.xml")
    interface WithoutUiBinder extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("Solution.ui.xml")
    interface Solution extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("UI.ui.xml")
    interface UI extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("HtmlCssJs.ui.xml")
    interface HtmlCssJs extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("XmlBinder.ui.xml")
    interface XmlBinder extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("JavaBinder.ui.xml")
    interface JavaBinder extends UiBinder<Widget, CodeSlide<?>> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addCodeSlide(GWT.create(WithoutUiBinder.class));
        addSlide(GWT.create(Solution.class));
        addSlide(GWT.create(UI.class));
        addCodeSlide(GWT.create(HtmlCssJs.class));
        addCodeSlide(GWT.create(XmlBinder.class));
        addCodeSlide(GWT.create(JavaBinder.class));
        addSlide(FormationGwt.PLAN);
    }

}
