package info.piwai.rockslide.client;

import info.piwai.rockslide.client.PresentationEntryPoint;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.ElementSlide;
import info.piwai.rockslide.client.welcome.Welcome;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class Documentation extends PresentationEntryPoint {

    @UiTemplate("Sections.ui.xml")
    public interface Sections extends UiBinder<Element, ElementSlide> {
        Sections binder = GWT.create(Sections.class);
    }

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Welcome());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.XML());
        brushes.add(Brushes.JAVA());
    }

}
