package info.piwai.cv.gwt.client.slider;

import info.piwai.cv.gwt.client.slider.slides.ChapterHolder;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;

public interface PresentationBuilder {

    void definePreloadedBrushes(List<Brush> brushes);

    void loadChapters(ChapterHolder chapterHolder);

}