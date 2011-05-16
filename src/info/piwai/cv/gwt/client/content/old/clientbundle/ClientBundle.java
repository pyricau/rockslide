package info.piwai.cv.gwt.client.content.old.clientbundle;

import info.piwai.cv.gwt.client.content.old.FormationGwt.Plan;
import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;
import info.piwai.cv.gwt.client.slider.slides.Chapter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class ClientBundle extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("Principe.ui.xml")
    interface Principe extends UiBinder<Element, ElementSlideNotes> {
        Principe binder = GWT.create(Principe.class);
    }

    @UiTemplate("Utilisation.ui.xml")
    interface Utilisation extends UiBinder<Widget, WidgetSlideNotes> {
        Utilisation binder = GWT.create(Utilisation.class);
    }

    @UiTemplate("Asynchronous.ui.xml")
    interface Asynchronous extends UiBinder<Widget, WidgetSlideNotes> {
        Asynchronous binder = GWT.create(Asynchronous.class);
    }

    @UiTemplate("I18N.ui.xml")
    interface I18N extends UiBinder<Widget, WidgetSlideNotes> {
        I18N binder = GWT.create(I18N.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addNotesSlide(Principe.binder);
        addWidgetNotesSlide(Utilisation.binder);
        addWidgetNotesSlide(Asynchronous.binder);
        addWidgetNotesSlide(I18N.binder);
        addSlide(Plan.binder);
    }

}
