package com.excilys.formation.gwt.client.formation.rpc;

import com.excilys.formation.gwt.client.formation.FormationGwt.Plan;
import com.excilys.formation.gwt.client.slider.slides.Chapter;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
import com.excilys.formation.gwt.client.slider.slides.WidgetSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class RPC extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("CommunicationClassique.ui.xml")
    interface CommunicationClassique extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("CommunicationGWT.ui.xml")
    interface CommunicationGWT extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("CommunicationRPC.ui.xml")
    interface CommunicationRPC extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("API.ui.xml")
    interface API extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Spring.ui.xml")
    interface Spring extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("Autres.ui.xml")
    interface Autres extends UiBinder<Element, ElementSlide> {}

    @UiTemplate("AsyncCallback.ui.xml")
    interface AsyncCallback extends UiBinder<Widget, WidgetSlide> {}

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(CommunicationClassique.class));
        addSlide(GWT.create(CommunicationGWT.class));
        addSlide(GWT.create(CommunicationRPC.class));
        addSlide(GWT.create(API.class));
        addWidgetSlide(GWT.create(AsyncCallback.class));
        addSlide(GWT.create(Spring.class));
        addSlide(GWT.create(Autres.class));
        addSlide(Plan.binder);
    }

}
