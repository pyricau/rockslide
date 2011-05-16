package info.piwai.cv.gwt.client.content;

import info.piwai.cv.gwt.client.content.welcome.Welcome;
import info.piwai.cv.gwt.client.slider.PresentationEntryPoint;
import info.piwai.cv.gwt.client.slider.slides.ChapterHolder;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;

public class CV extends PresentationEntryPoint {

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Welcome());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.XML());
    }

}
