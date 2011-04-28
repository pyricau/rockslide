package com.excilys.formation.gwt.client.formation.clientbundle;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.shownotes.ElementSlideNotes;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class ClientBundle extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {}

    @UiTemplate("Principe.ui.xml")
    interface Principe extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Utilisation.ui.xml")
    interface Utilisation extends UiBinder<Widget, WidgetSlide> {}

    @UiTemplate("Asynchronous.ui.xml")
    interface Asynchronous extends UiBinder<Widget, WidgetSlide> {}

    @UiTemplate("I18N.ui.xml")
    interface I18N extends UiBinder<Widget, WidgetSlide> {}

    @Override
    protected void buildSlides() {
        addNotesSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Principe.class));
        addWidgetSlide(GWT.create(Utilisation.class));
        addWidgetSlide(GWT.create(Asynchronous.class));
        addWidgetSlide(GWT.create(I18N.class));
        addSlide(FormationGwt.PLAN);
    }

}
