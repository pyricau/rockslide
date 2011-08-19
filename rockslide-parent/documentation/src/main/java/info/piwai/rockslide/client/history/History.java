package info.piwai.rockslide.client.history;

import info.piwai.rockslide.client.slides.Chapter;
import info.piwai.rockslide.client.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class History extends Chapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }
    
    @UiTemplate("CV.ui.xml")
    interface CV extends UiBinder<Element, ElementSlide> {
        CV binder = GWT.create(CV.class);
    }
    
    @UiTemplate("GWTHTML5Rocks.ui.xml")
    interface GWTHTML5Rocks extends UiBinder<Element, ElementSlide> {
        GWTHTML5Rocks binder = GWT.create(GWTHTML5Rocks.class);
    }
    
    
    @UiTemplate("GWTTraining.ui.xml")
    interface GWTTraining extends UiBinder<Element, ElementSlide> {
        GWTTraining binder = GWT.create(GWTTraining.class);
    }
    
    @UiTemplate("HTML5Rocks.ui.xml")
    interface HTML5Rocks extends UiBinder<Element, ElementSlide> {
        HTML5Rocks binder = GWT.create(HTML5Rocks.class);
    }
    
    @UiTemplate("Landslide.ui.xml")
    interface Landslide extends UiBinder<Element, ElementSlide> {
        Landslide binder = GWT.create(Landslide.class);
    }
    
    @UiTemplate("Rockslide.ui.xml")
    interface Rockslide extends UiBinder<Element, ElementSlide> {
        Rockslide binder = GWT.create(Rockslide.class);
    }


    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(HTML5Rocks.binder);
        addSlide(GWTHTML5Rocks.binder);
        addSlide(GWTTraining.binder);
        addSlide(CV.binder);
        addSlide(Rockslide.binder);
        addSlide(Landslide.binder);
        addTableOfContent();
    }
}
