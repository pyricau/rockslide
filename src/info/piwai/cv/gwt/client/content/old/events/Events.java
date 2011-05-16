package info.piwai.cv.gwt.client.content.old.events;

import info.piwai.cv.gwt.client.content.old.FormationGwt.Plan;
import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;
import info.piwai.cv.gwt.client.slider.slides.Chapter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Events extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Principe.ui.xml")
    interface Principe extends UiBinder<Element, ElementSlideNotes> {
        Principe binder = GWT.create(Principe.class);
    }

    @UiTemplate("CustomEvent.ui.xml")
    interface CustomEvent extends UiBinder<Widget, WidgetSlideNotes> {
        CustomEvent binder = GWT.create(CustomEvent.class);
    }

    @UiTemplate("RegisterHandler.ui.xml")
    interface RegisterHandler extends UiBinder<Widget, WidgetSlideNotes> {
        RegisterHandler binder = GWT.create(RegisterHandler.class);
    }

    @UiTemplate("EventBus.ui.xml")
    interface EventBus extends UiBinder<Widget, WidgetSlideNotes> {
        EventBus binder = GWT.create(EventBus.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(Principe.binder);
        addWidgetNotesSlide(CustomEvent.binder);
        addWidgetNotesSlide(RegisterHandler.binder);
        addWidgetNotesSlide(EventBus.binder);
        addSlide(Plan.binder);
    }

}
