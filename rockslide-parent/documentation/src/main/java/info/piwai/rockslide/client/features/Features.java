package info.piwai.rockslide.client.features;

import info.piwai.rockslide.client.shownotes.WidgetSlideNotes;
import info.piwai.rockslide.client.slides.Chapter;
import info.piwai.rockslide.client.slides.ElementSlide;
import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

public class Features extends Chapter {

    @UiTemplate("Title.ui.xml")
    interface Title extends UiBinder<Element, ElementSlide> {
        Title binder = GWT.create(Title.class);
    }
    
    @UiTemplate("Analytics.ui.xml")
    interface Analytics extends UiBinder<Widget, WidgetSlide> {
        Analytics binder = GWT.create(Analytics.class);
    }
    
    @UiTemplate("ManyMore.ui.xml")
    interface ManyMore extends UiBinder<Element, ElementSlide> {
        ManyMore binder = GWT.create(ManyMore.class);
    }
    
    @UiTemplate("Webapp.ui.xml")
    interface Webapp extends UiBinder<Element, ElementSlide> {
        Webapp binder = GWT.create(Webapp.class);
    }
    
    @UiTemplate("ShowNotes.ui.xml")
    interface ShowNotes extends UiBinder<Widget, WidgetSlideNotes> {
        ShowNotes binder = GWT.create(ShowNotes.class);
    }
    
    @UiTemplate("SlidesAsCode.ui.xml")
    interface SlidesAsCode extends UiBinder<Element, ElementSlide> {
        SlidesAsCode binder = GWT.create(SlidesAsCode.class);
    }

    @Override
    protected void buildSlides() {
        addSlide(Title.binder);
        addSlide(SlidesAsCode.binder);
        addSlide(Webapp.binder);
        addWidgetSlide(Analytics.binder);
        addWidgetNotesSlide(ShowNotes.binder);
        addPresentable(new ClassicGWT());
        addSlide(ManyMore.binder);
        addTableOfContent();
    }
}
