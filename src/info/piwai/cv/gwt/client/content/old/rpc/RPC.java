package info.piwai.cv.gwt.client.content.old.rpc;

import info.piwai.cv.gwt.client.content.old.FormationGwt.Plan;
import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;
import info.piwai.cv.gwt.client.slider.slides.Chapter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class RPC extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("CommunicationClassique.ui.xml")
    interface CommunicationClassique extends UiBinder<Element, ElementSlideNotes> {
        CommunicationClassique binder = GWT.create(CommunicationClassique.class);
    }

    @UiTemplate("CommunicationGWT.ui.xml")
    interface CommunicationGWT extends UiBinder<Element, ElementSlideNotes> {
        CommunicationGWT binder = GWT.create(CommunicationGWT.class);
    }

    @UiTemplate("CommunicationRPC.ui.xml")
    interface CommunicationRPC extends UiBinder<Element, ElementSlideNotes> {
        CommunicationRPC binder = GWT.create(CommunicationRPC.class);
    }

    @UiTemplate("API.ui.xml")
    interface API extends UiBinder<Element, ElementSlideNotes> {
        API binder = GWT.create(API.class);
    }

    @UiTemplate("Spring.ui.xml")
    interface Spring extends UiBinder<Element, ElementSlideNotes> {
        Spring binder = GWT.create(Spring.class);
    }

    @UiTemplate("Autres.ui.xml")
    interface Autres extends UiBinder<Element, ElementSlideNotes> {
        Autres binder = GWT.create(Autres.class);
    }

    @UiTemplate("AsyncCallback.ui.xml")
    interface AsyncCallback extends UiBinder<Widget, WidgetSlideNotes> {
        AsyncCallback binder = GWT.create(AsyncCallback.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(CommunicationClassique.binder);
        addNotesSlide(CommunicationGWT.binder);
        addNotesSlide(CommunicationRPC.binder);
        addNotesSlide(API.binder);
        addWidgetNotesSlide(AsyncCallback.binder);
        addNotesSlide(Spring.binder);
        addNotesSlide(Autres.binder);
        addSlide(Plan.binder);
    }

}
