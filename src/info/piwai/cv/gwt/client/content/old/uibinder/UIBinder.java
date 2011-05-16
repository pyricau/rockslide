package info.piwai.cv.gwt.client.content.old.uibinder;

import info.piwai.cv.gwt.client.content.old.FormationGwt.Plan;
import info.piwai.cv.gwt.client.slider.shownotes.ElementSlideNotes;
import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;
import info.piwai.cv.gwt.client.slider.slides.Chapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class UIBinder extends Chapter {

    @UiTemplate("Titre.ui.xml")
    interface Titre extends UiBinder<Element, ElementSlideNotes> {
        Titre binder = GWT.create(Titre.class);
    }

    @UiTemplate("WithoutUiBinder.ui.xml")
    interface WithoutUiBinder extends UiBinder<Widget, WidgetSlideNotes> {
        WithoutUiBinder binder = GWT.create(WithoutUiBinder.class);
    }

    @UiTemplate("Solution.ui.xml")
    interface Solution extends UiBinder<Element, ElementSlide> {
        Solution binder = GWT.create(Solution.class);
    }

    @UiTemplate("UI.ui.xml")
    interface UI extends UiBinder<Element, ElementSlide> {
        UI binder = GWT.create(UI.class);
    }

    @UiTemplate("HtmlCssJs.ui.xml")
    interface HtmlCssJs extends UiBinder<Widget, WidgetSlideNotes> {
        HtmlCssJs binder = GWT.create(HtmlCssJs.class);
    }

    @UiTemplate("XmlBinder.ui.xml")
    interface XmlBinder extends UiBinder<Widget, WidgetSlideNotes> {
        XmlBinder binder = GWT.create(XmlBinder.class);
    }

    @UiTemplate("JavaBinder.ui.xml")
    interface JavaBinder extends UiBinder<Widget, WidgetSlideNotes> {
        JavaBinder binder = GWT.create(JavaBinder.class);
    }

    @Override
    protected void buildSlides() {
        addNotesSlide(Titre.binder);
        addWidgetNotesSlide(WithoutUiBinder.binder);
        addSlide(Solution.binder);
        addSlide(UI.binder);
        addWidgetNotesSlide(HtmlCssJs.binder);
        addWidgetNotesSlide(XmlBinder.binder);
        addWidgetNotesSlide(JavaBinder.binder);
        addSlide(Plan.binder);
    }

}
