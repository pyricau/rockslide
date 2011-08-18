package info.piwai.rockslide.client.welcome;

import info.piwai.rockslide.client.HeaderChapter;
import info.piwai.rockslide.client.Documentation.Sections;
import info.piwai.rockslide.client.slides.ElementSlide;
import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Welcome extends HeaderChapter {

    @UiTemplate("Hello.ui.xml")
    interface Hello extends UiBinder<Element, ElementSlide> {
        Hello binder = GWT.create(Hello.class);
    }

    @UiTemplate("CreateYours.ui.xml")
    interface CreateYours extends UiBinder<Widget, WidgetSlide> {
        CreateYours binder = GWT.create(CreateYours.class);
    }

    @UiTemplate("Intro.ui.xml")
    interface Intro extends UiBinder<Widget, WidgetSlide> {
        Intro binder = GWT.create(Intro.class);
    }


    @UiTemplate("SomePage.ui.xml")
    interface SomePage extends UiBinder<Element, ElementSlide> {
        SomePage binder = GWT.create(SomePage.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Hello.binder);
        addWidgetSlide(Intro.binder);
        addSlide(SomePage.binder);
        addWidgetSlide(CreateYours.binder);
        addSlide(Sections.binder);
    }
}
