package info.piwai.rockslide.client.slides;

import java.util.List;

public interface ChapterHolder {

    void addChapter(Chapter chapter);
    
    List<ChapterName> getChapterNames();

}