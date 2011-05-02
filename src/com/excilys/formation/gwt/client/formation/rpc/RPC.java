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
    interface Titre extends UiBinder<Element, ElementSlide> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("CommunicationClassique.ui.xml")
    interface CommunicationClassique extends UiBinder<Element, ElementSlide> {
        CommunicationClassique binder = GWT.create(CommunicationClassique.class);
    }

    @UiTemplate("CommunicationGWT.ui.xml")
    interface CommunicationGWT extends UiBinder<Element, ElementSlide> {
        CommunicationGWT binder = GWT.create(CommunicationGWT.class);
    }

    @UiTemplate("CommunicationRPC.ui.xml")
    interface CommunicationRPC extends UiBinder<Element, ElementSlide> {
        CommunicationRPC binder = GWT.create(CommunicationRPC.class);
    }

    @UiTemplate("API.ui.xml")
    interface API extends UiBinder<Element, ElementSlide> {
        API binder = GWT.create(API.class);
    }

    @UiTemplate("Spring.ui.xml")
    interface Spring extends UiBinder<Element, ElementSlide> {
        Spring binder = GWT.create(Spring.class);
    }

    @UiTemplate("Autres.ui.xml")
    interface Autres extends UiBinder<Element, ElementSlide> {
        Autres binder = GWT.create(Autres.class);
    }

    @UiTemplate("AsyncCallback.ui.xml")
    interface AsyncCallback extends UiBinder<Widget, WidgetSlide> {
        AsyncCallback binder = GWT.create(AsyncCallback.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Titre.binder);
        addSlide(CommunicationClassique.binder);
        addSlide(CommunicationGWT.binder);
        addSlide(CommunicationRPC.binder);
        addSlide(API.binder);
        addWidgetSlide(AsyncCallback.binder);
        addSlide(Spring.binder);
        addSlide(Autres.binder);
        addSlide(Plan.binder);
    }

}
