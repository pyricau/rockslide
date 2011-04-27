package com.excilys.formation.gwt.client.formation.clientbundle;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.CodeSlide;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class ClientBundle extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Principe.ui.xml")
    interface Principe extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Utilisation.ui.xml")
    interface Utilisation extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("Asynchronous.ui.xml")
    interface Asynchronous extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("I18N.ui.xml")
    interface I18N extends UiBinder<Widget, CodeSlide<?>> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Principe.class));
        addCodeSlide(GWT.create(Utilisation.class));
        addCodeSlide(GWT.create(Asynchronous.class));
        addCodeSlide(GWT.create(I18N.class));
        addSlide(FormationGwt.PLAN);
    }

}
