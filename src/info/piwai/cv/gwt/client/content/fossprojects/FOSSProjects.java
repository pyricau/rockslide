package info.piwai.cv.gwt.client.content.fossprojects;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.content.HeaderChapter;
import info.piwai.cv.gwt.client.content.WIP;
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

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addPresentable(new WIP("AndroidAnnotations"), "AndroidAnnotations");
        addPresentable(new WIP("GWT Landlisde"), "GWTLandlisde");
        addPresentable(new WIP("FunkyJFunctional"), "FunkyJFunctional");
        addPresentable(new WIP("Android"), "Android");
        addPresentable(new WIP("GWT"), "GWT");
        addPresentable(new WIP("C++"), "C++");
        addPresentable(new WIP("PHP"), "PHP");
        addSlide(Sections.binder);
    }
}
