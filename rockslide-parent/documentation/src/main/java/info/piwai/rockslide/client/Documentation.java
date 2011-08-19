package info.piwai.rockslide.client;

import info.piwai.rockslide.client.slides.Analytics;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.PresentationHeader;
import info.piwai.rockslide.client.welcome.Welcome;
import info.piwai.rockslide.sh.client.SyntaxHighlighter;

import com.google.gwt.user.client.ui.IsWidget;

public class Documentation extends PresentationEntryPoint {

    private PresentationHeader header;

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
        holder.addChapter(new Welcome());
        
        header = new PresentationHeader(holder);
    }
    
    @Override
    public IsWidget getHeaderWidget() {
        return header;
    }

}
