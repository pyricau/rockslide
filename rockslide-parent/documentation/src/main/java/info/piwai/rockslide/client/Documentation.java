package info.piwai.rockslide.client;

import info.piwai.rockslide.client.features.Features;
import info.piwai.rockslide.client.gettingstarted.GettingStarted;
import info.piwai.rockslide.client.history.History;
import info.piwai.rockslide.client.slides.Analytics;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.PresentationHeader;
import info.piwai.rockslide.client.welcome.Welcome;
import info.piwai.rockslide.sh.client.SyntaxHighlighter;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

public class Documentation extends PresentationEntryPoint {

    private PresentationHeader header;

    @Override
    public void initSlides() {
        
        RootPanel.get().add(new Ribbon());

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
        Analytics.enable("UA-5875795-16");
    }

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Welcome());
        holder.addChapter(new Features());
        holder.addChapter(new GettingStarted());
        holder.addChapter(new History());
        
        header = new PresentationHeader(holder);
    }
    
    @Override
    public IsWidget getHeaderWidget() {
        return header;
    }

}
