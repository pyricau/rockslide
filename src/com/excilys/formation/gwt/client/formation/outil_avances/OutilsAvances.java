package com.excilys.formation.gwt.client.formation.outil_avances;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.CodeSlide;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.excilys.formation.gwt.client.slider.WidgetSlide;
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
    interface ExtGWT extends UiBinder<Widget, WidgetSlide> {}

    @UiTemplate("SmartGWT.ui.xml")
    interface SmartGWT extends UiBinder<Widget, WidgetSlide> {}

    @UiTemplate("GoogleGin.ui.xml")
    interface GoogleGin extends UiBinder<Widget, CodeSlide<?>> {}

    @UiTemplate("GwtDnd.ui.xml")
    interface GwtDnd extends UiBinder<Widget, WidgetSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(Log.class));
        addSlide(GWT.create(Liste.class));
        addSlide(GWT.create(Visualization.class));
        addWidgetSlide(GWT.create(ExtGWT.class));
        addWidgetSlide(GWT.create(SmartGWT.class));
        addCodeSlide(GWT.create(GoogleGin.class));
        addWidgetSlide(GWT.create(GwtDnd.class));
        addSlide(FormationGwt.PLAN);
    }

}
