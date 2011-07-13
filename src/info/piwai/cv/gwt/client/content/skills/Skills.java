package info.piwai.cv.gwt.client.content.skills;

import info.piwai.cv.gwt.client.content.CV.Sections;
import info.piwai.cv.gwt.client.content.HeaderChapter;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Skills extends HeaderChapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }

    @UiTemplate("ComputerLanguages.ui.xml")
    interface ComputerLanguages extends UiBinder<Element, ElementSlide> {
        ComputerLanguages binder = GWT.create(ComputerLanguages.class);
    }

    @UiTemplate("DevTools.ui.xml")
    interface DevTools extends UiBinder<Element, ElementSlide> {
        DevTools binder = GWT.create(DevTools.class);
    }

    @UiTemplate("Frameworks.ui.xml")
    interface Frameworks extends UiBinder<Element, ElementSlide> {
        Frameworks binder = GWT.create(Frameworks.class);
    }

    @UiTemplate("OSServersDB.ui.xml")
    interface OSServersDB extends UiBinder<Element, ElementSlide> {
        OSServersDB binder = GWT.create(OSServersDB.class);
    }

    @UiTemplate("SpokenLanguages.ui.xml")
    interface SpokenLanguages extends UiBinder<Element, ElementSlide> {
        SpokenLanguages binder = GWT.create(SpokenLanguages.class);
    }

    @UiTemplate("Methods.ui.xml")
    interface Methods extends UiBinder<Element, ElementSlide> {
        Methods binder = GWT.create(Methods.class);
    }

    @UiTemplate("FunctionalSkills.ui.xml")
    interface FunctionalSkills extends UiBinder<Element, ElementSlide> {
        FunctionalSkills binder = GWT.create(FunctionalSkills.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(ComputerLanguages.binder);
        addSlide(DevTools.binder);
        addSlide(Frameworks.binder);
        addPresentable(new ElementSlide(OSServersDB.binder), "OS-Servers-DB");
        addSlide(SpokenLanguages.binder);
        addSlide(Methods.binder);
        addSlide(FunctionalSkills.binder);
        addSlide(Sections.binder);
    }
}
