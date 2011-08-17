package info.piwai.rockslide.client.welcome;

import info.piwai.rockslide.client.HeaderChapter;
import info.piwai.rockslide.client.Documentation.Sections;
import info.piwai.rockslide.client.slides.ElementSlide;
import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Welcome extends HeaderChapter {

    @UiTemplate("Hello.ui.xml")
    interface Hello extends UiBinder<Element, ElementSlide> {
        Hello binder = GWT.create(Hello.class);
    }

    @UiTemplate("StealThisSlideshow.ui.xml")
    interface StealThisSlideshow extends UiBinder<Widget, WidgetSlide> {
        StealThisSlideshow binder = GWT.create(StealThisSlideshow.class);
    }

    @UiTemplate("SoftwareEngineer.ui.xml")
    interface SoftwareEngineer extends UiBinder<Widget, WidgetSlide> {
        SoftwareEngineer binder = GWT.create(SoftwareEngineer.class);
    }

    @UiTemplate("SocialCoder.ui.xml")
    interface SocialCoder extends UiBinder<Element, ElementSlide> {
        SocialCoder binder = GWT.create(SocialCoder.class);
    }

    @UiTemplate("StuffILike.ui.xml")
    interface StuffILike extends UiBinder<Element, ElementSlide> {
        StuffILike binder = GWT.create(StuffILike.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Hello.binder);
        addWidgetSlide(SoftwareEngineer.binder);
        addSlide(SocialCoder.binder);
        addPresentable(new JobOffers());
        addSlide(StuffILike.binder);
        addWidgetSlide(StealThisSlideshow.binder);
        addSlide(Sections.binder);
    }
}
