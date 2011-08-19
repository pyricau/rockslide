package info.piwai.rockslide.client.slides;

public class UlTableOfContentFactory implements TableOfContentFactory {
    
    private final ChapterHolder chapterHolder;
    
    public UlTableOfContentFactory(ChapterHolder chapterHolder) {
        this.chapterHolder = chapterHolder;
    }

    @Override
    public Presentable buildTableOfContent() {
        return new ULTableOfContent(chapterHolder);
    }

}
