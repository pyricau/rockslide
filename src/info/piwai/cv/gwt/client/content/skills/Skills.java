package info.piwai.cv.gwt.client.content.skills;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.slider.slides.Chapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Skills extends Chapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(Sections.binder);
    }
}
