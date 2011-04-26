package com.excilys.formation.gwt.client.formation.rpc;

import com.excilys.formation.gwt.client.formation.FormationGwt;
import com.excilys.formation.gwt.client.slider.Chapter;
import com.excilys.formation.gwt.client.slider.ElementSlide;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

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

    @Override
    protected void buildSlides() {
        addSlide(GWT.create(Titre.class));
        addSlide(GWT.create(CommunicationClassique.class));
        addSlide(GWT.create(CommunicationGWT.class));
        addSlide(GWT.create(CommunicationRPC.class));
        addSlide(GWT.create(API.class));
        addPresentable(new AsyncCallback());
        addSlide(GWT.create(Spring.class));
        addSlide(GWT.create(Autres.class));
        addSlide(FormationGwt.PLAN);
    }

}
