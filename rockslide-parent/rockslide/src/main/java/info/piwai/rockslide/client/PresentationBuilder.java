package info.piwai.rockslide.client;

import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.HasHeaderWidget;
import info.piwai.rockslide.client.slides.TableOfContentFactory;

public interface PresentationBuilder extends HasHeaderWidget {

    void loadChapters(ChapterHolder chapterHolder);
    
    TableOfContentFactory buildTableOfContentFactory(ChapterHolder chapterHolder);
    
}