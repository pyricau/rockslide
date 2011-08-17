package info.piwai.cv.gwt.client.content.education;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.content.HeaderChapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Education extends HeaderChapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }

    @UiTemplate("INSARouen.ui.xml")
    interface INSARouen extends UiBinder<Element, ElementSlide> {
        INSARouen binder = GWT.create(INSARouen.class);
    }

    @UiTemplate("KTH.ui.xml")
    interface KTH extends UiBinder<Element, ElementSlide> {
        KTH binder = GWT.create(KTH.class);
    }

    @UiTemplate("Schweitzer.ui.xml")
    interface Schweitzer extends UiBinder<Element, ElementSlide> {
        Schweitzer binder = GWT.create(Schweitzer.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(INSARouen.binder);
        addSlide(KTH.binder);
        addSlide(Schweitzer.binder);
        addSlide(Sections.binder);
    }
}
