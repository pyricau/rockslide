package info.piwai.cv.gwt.client.content.old.outil_avances;

import info.piwai.cv.gwt.client.content.old.FormationGwt.Plan;
import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.VisibleSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;
import info.piwai.cv.gwt.client.slider.slides.Chapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class OutilsAvances extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Log.ui.xml")
    interface Log extends UiBinder<Element, ElementSlideNotes> {
        Log binder = GWT.create(Log.class);
    }

    @UiTemplate("Liste.ui.xml")
    interface Liste extends UiBinder<Element, ElementSlide> {
        Liste binder = GWT.create(Liste.class);
    }

    @UiTemplate("Visualization.ui.xml")
    interface Visualization extends UiBinder<Element, ElementSlideNotes> {
        Visualization binder = GWT.create(Visualization.class);
    }

    @UiTemplate("ExtGWT.ui.xml")
    interface ExtGWT extends UiBinder<Widget, VisibleSlideNotes> {
        ExtGWT binder = GWT.create(ExtGWT.class);
    }

    @UiTemplate("SmartGWT.ui.xml")
    interface SmartGWT extends UiBinder<Widget, VisibleSlideNotes> {
        SmartGWT binder = GWT.create(SmartGWT.class);
    }

    @UiTemplate("GoogleGin.ui.xml")
    interface GoogleGin extends UiBinder<Widget, WidgetSlideNotes> {
        GoogleGin binder = GWT.create(GoogleGin.class);
    }

    @UiTemplate("GwtDnd.ui.xml")
    interface GwtDnd extends UiBinder<Widget, VisibleSlideNotes> {
        GwtDnd binder = GWT.create(GwtDnd.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(Log.binder);
        addSlide(Liste.binder);
        addNotesSlide(Visualization.binder);
        addVisibleNotesSlide(ExtGWT.binder);
        addVisibleNotesSlide(SmartGWT.binder);
        addWidgetNotesSlide(GoogleGin.binder);
        addVisibleNotesSlide(GwtDnd.binder);
        addSlide(Plan.binder);
    }

}
