package info.piwai.rockslide.client;

import info.piwai.rockslide.client.slides.ChapterHolder;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;

public interface PresentationBuilder {

    void definePreloadedBrushes(List<Brush> brushes);

    void loadChapters(ChapterHolder chapterHolder);

}