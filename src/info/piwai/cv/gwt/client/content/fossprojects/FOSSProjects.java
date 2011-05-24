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

        // Add a code sample
        addPresentable(new WIP("AndroidAnnotations"), "AndroidAnnotations");

        // Name will change.. code sample too
        addPresentable(new WIP("GWT Landlisde"), "GWTLandlisde");

        // Code sample too
        addPresentable(new WIP("FunkyJFunctional"), "FunkyJFunctional");

        // involved in maven android community, worked on RoboGuice, mavenized
        // ACRA
        addPresentable(new WIP("Android"), "Android");

        // Projects from google code
        addPresentable(new WIP("GWT"), "GWT");

        // 2H4U, OpenGF
        addPresentable(new WIP("C++"), "C++");

        // Plagiasi, Bisouland
        addPresentable(new WIP("PHP"), "PHP");
        addSlide(Sections.binder);
    }
}
