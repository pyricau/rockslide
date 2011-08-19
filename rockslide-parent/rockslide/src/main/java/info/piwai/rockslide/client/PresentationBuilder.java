package info.piwai.rockslide.client;

import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.HasHeaderWidget;

public interface PresentationBuilder extends HasHeaderWidget {

    void loadChapters(ChapterHolder chapterHolder);
    
}