package info.piwai.cv.gwt.client.content.experience;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.content.HeaderChapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Experience extends HeaderChapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }

    @UiTemplate("Trainer.ui.xml")
    interface Trainer extends UiBinder<Element, ElementSlide> {
        Trainer binder = GWT.create(Trainer.class);
    }

    @UiTemplate("Bfinance.ui.xml")
    interface Bfinance extends UiBinder<Element, ElementSlide> {
        Bfinance binder = GWT.create(Bfinance.class);
    }

    @UiTemplate("Excilys.ui.xml")
    interface Excilys extends UiBinder<Element, ElementSlide> {
        Excilys binder = GWT.create(Excilys.class);
    }

    @UiTemplate("JCDecaux.ui.xml")
    interface JCDecaux extends UiBinder<Element, ElementSlide> {
        JCDecaux binder = GWT.create(JCDecaux.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(Excilys.binder);
        addSlide(Trainer.binder);
        addSlide(Bfinance.binder);
        addSlide(JCDecaux.binder);
        addSlide(Sections.binder);
    }
}
