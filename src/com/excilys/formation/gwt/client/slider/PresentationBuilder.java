package com.excilys.formation.gwt.client.slider;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;

public interface PresentationBuilder {

    void definePreloadedBrushes(List<Brush> brushes);

    void loadChapters(ChapterHolder chapterHolder);

}