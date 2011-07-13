package info.piwai.cv.gwt.client.content.fossprojects;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.content.HeaderChapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class FOSSProjects extends HeaderChapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }

    @UiTemplate("AndroidAnnotations.ui.xml")
    interface AndroidAnnotations extends UiBinder<Element, ElementSlide> {
        AndroidAnnotations binder = GWT.create(AndroidAnnotations.class);
    }

    @UiTemplate("GWTLandslide.ui.xml")
    interface GWTLandslide extends UiBinder<Element, ElementSlide> {
        GWTLandslide binder = GWT.create(GWTLandslide.class);
    }

    @UiTemplate("FunkyJFunctional.ui.xml")
    interface FunkyJFunctional extends UiBinder<Element, ElementSlide> {
        FunkyJFunctional binder = GWT.create(FunkyJFunctional.class);
    }

    @UiTemplate("2H4U.ui.xml")
    interface GAME_2H4U extends UiBinder<Element, ElementSlide> {
        GAME_2H4U binder = GWT.create(GAME_2H4U.class);
    }

    @UiTemplate("Android.ui.xml")
    interface Android extends UiBinder<Element, ElementSlide> {
        Android binder = GWT.create(Android.class);
    }

    @UiTemplate("GWT.ui.xml")
    interface FOSS_GWT extends UiBinder<Element, ElementSlide> {
        FOSS_GWT binder = GWT.create(FOSS_GWT.class);
    }

    @UiTemplate("CPP.ui.xml")
    interface CPP extends UiBinder<Element, ElementSlide> {
        CPP binder = GWT.create(CPP.class);
    }

    @UiTemplate("PHP.ui.xml")
    interface PHP extends UiBinder<Element, ElementSlide> {
        PHP binder = GWT.create(PHP.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(AndroidAnnotations.binder);
        addSlide(GWTLandslide.binder);
        addSlide(FunkyJFunctional.binder);
        addPresentable(new ElementSlide(GAME_2H4U.binder), "2H4U");
        addSlide(Android.binder);
        addPresentable(new ElementSlide(FOSS_GWT.binder), "GWT");
        addPresentable(new ElementSlide(CPP.binder), "C++");
        addSlide(PHP.binder);
        addSlide(Sections.binder);
    }
}
