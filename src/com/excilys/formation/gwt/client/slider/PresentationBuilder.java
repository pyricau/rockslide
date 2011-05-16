package com.excilys.formation.gwt.client.slider;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.excilys.formation.gwt.client.slider.slides.ChapterHolder;

public interface PresentationBuilder {

    void definePreloadedBrushes(List<Brush> brushes);

    void loadChapters(ChapterHolder chapterHolder);

}