package info.piwai.rockslide.client.gettingstarted;

import info.piwai.rockslide.client.slides.Chapter;
import info.piwai.rockslide.client.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class GettingStarted extends Chapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }
    
    @UiTemplate("DIY.ui.xml")
    interface DIY extends UiBinder<Element, ElementSlide> {
        DIY binder = GWT.create(DIY.class);
    }


    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(DIY.binder);
        addTableOfContent();
    }
    
    @Override
    public String getReadableName() {
        return "Getting Started";
    }
}
