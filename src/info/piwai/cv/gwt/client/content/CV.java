package info.piwai.cv.gwt.client.content;

import info.piwai.cv.gwt.client.content.contact.Contact;
import info.piwai.cv.gwt.client.content.education.Education;
import info.piwai.cv.gwt.client.content.jobs.Jobs;
import info.piwai.cv.gwt.client.content.projects.Projects;
import info.piwai.cv.gwt.client.content.skills.Skills;
import info.piwai.cv.gwt.client.content.welcome.Welcome;
import info.piwai.cv.gwt.client.slider.PresentationEntryPoint;
import info.piwai.cv.gwt.client.slider.slides.ChapterHolder;
import info.piwai.cv.gwt.client.slider.slides.ElementSlide;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

public class CV extends PresentationEntryPoint {

    @UiTemplate("Sections.ui.xml")
    public interface Sections extends UiBinder<Element, ElementSlide> {
        Sections binder = GWT.create(Sections.class);
    }

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Welcome());
        holder.addChapter(new Jobs());
        holder.addChapter(new Projects());
        holder.addChapter(new Skills());
        holder.addChapter(new Education());
        holder.addChapter(new Contact());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.XML());
        brushes.add(Brushes.JAVA());
    }

}
