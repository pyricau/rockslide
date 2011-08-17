package info.piwai.cv.gwt.client.content.contact;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.content.HeaderChapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Contact extends HeaderChapter {

    @UiTemplate("ContactMe.ui.xml")
    interface ContactMe extends UiBinder<Element, ElementSlide> {
        ContactMe binder = GWT.create(ContactMe.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(ContactMe.binder);
        addSlide(Sections.binder);
    }
}
