package info.piwai.cv.gwt.client.content.old.development_mode;

import info.piwai.cv.gwt.client.content.old.FormationGwt.Plan;
import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;
import info.piwai.cv.gwt.client.slider.slides.Chapter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class DevelopmentMode extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Indispensable.ui.xml")
    interface Indispensable extends UiBinder<Element, ElementSlideNotes> {
        Indispensable binder = GWT.create(Indispensable.class);
    }

    @UiTemplate("Debug.ui.xml")
    interface Debug extends UiBinder<Widget, WidgetSlideNotes> {
        Debug binder = GWT.create(Debug.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(Indispensable.binder);
        addWidgetNotesSlide(Debug.binder);
        addSlide(Plan.binder);
    }

}
