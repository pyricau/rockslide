package info.piwai.cv.gwt.client.content.welcome;

import info.piwai.cv.gwt.client.slider.slides.Chapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;
import info.piwai.cv.gwt.client.slider.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Welcome extends Chapter {

    @UiTemplate("Hello.ui.xml")
    interface Hello extends UiBinder<Element, ElementSlide> {
        Hello binder = GWT.create(Hello.class);
    }

    @UiTemplate("Steal.ui.xml")
    interface Steal extends UiBinder<Widget, WidgetSlide> {
        Steal binder = GWT.create(Steal.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Hello.binder);
        addWidgetSlide(Steal.binder);
    }
}
