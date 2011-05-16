package info.piwai.cv.gwt.client.content.old.introduction;

import info.piwai.cv.gwt.client.content.old.FormationGwt.Plan;
import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.slides.Chapter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Introduction extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("AQuoi.ui.xml")
    interface AQuoi extends UiBinder<Element, ElementSlideNotes> {
        AQuoi binder = GWT.create(AQuoi.class);
    }

    @UiTemplate("Historique.ui.xml")
    interface Historique extends UiBinder<Element, ElementSlideNotes> {
        Historique binder = GWT.create(Historique.class);
    }

    @UiTemplate("Fonctionnement.ui.xml")
    interface Fonctionnement extends UiBinder<Element, ElementSlideNotes> {
        Fonctionnement binder = GWT.create(Fonctionnement.class);
    }

    @UiTemplate("Compilation.ui.xml")
    interface Compilation extends UiBinder<Element, ElementSlideNotes> {
        Compilation binder = GWT.create(Compilation.class);
    }

    @UiTemplate("Limitations.ui.xml")
    interface Limitations extends UiBinder<Element, ElementSlideNotes> {
        Limitations binder = GWT.create(Limitations.class);
    }

    @UiTemplate("Concurrents.ui.xml")
    interface Concurrents extends UiBinder<Element, ElementSlideNotes> {
        Concurrents binder = GWT.create(Concurrents.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(AQuoi.binder);
        addNotesSlide(Historique.binder);
        addNotesSlide(Fonctionnement.binder);
        addNotesSlide(Compilation.binder);
        addPresentable(new TropSimple());
        addNotesSlide(Limitations.binder);
        addNotesSlide(Concurrents.binder);
        addSlide(Plan.binder);
    }

}
