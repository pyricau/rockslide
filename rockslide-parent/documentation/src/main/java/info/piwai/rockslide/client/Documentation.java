package info.piwai.rockslide.client;

import info.piwai.rockslide.client.slides.Analytics;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.ElementSlide;
import info.piwai.rockslide.client.welcome.Welcome;
import info.piwai.rockslide.sh.client.SyntaxHighlighter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Documentation extends PresentationEntryPoint {

    @UiTemplate("Sections.ui.xml")
    public interface Sections extends UiBinder<Element, ElementSlide> {
        Sections binder = GWT.create(Sections.class);
    }

    @Override
    public void init() {

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
    }

}
