package info.piwai.rockslide.client;

import info.piwai.rockslide.client.slides.Analytics;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.ElementSlide;
import info.piwai.rockslide.client.welcome.Welcome;
import info.piwai.rockslide.sh.client.SyntaxHighlighter;
import info.piwai.rockslide.client.slides.PresentationHeader;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.IsWidget;

public class Documentation extends PresentationEntryPoint {

    private PresentationHeader header;

    @UiTemplate("Chapters.ui.xml")
    public interface Chapters extends UiBinder<Element, ElementSlide> {
        Chapters binder = GWT.create(Chapters.class);
    }

    @Override
    public void initSlides() {

        /**
         * Custom CSS injection
         */
        DocumentationResources.instance.documentation().ensureInjected();

        /**
         * Default options of SyntaxHighlighter
         */
        SyntaxHighlighter.toolbar = false;

        /**
         * Will only work if the module info.piwai.rockslide.ga.SlideAnalytics
         * is imported
         */
        Analytics.enable("UA-XXX");
    }

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Welcome());
        
        header = new PresentationHeader(holder);
    }
    
    @Override
    public IsWidget getHeaderWidget() {
        return header;
    }

}
