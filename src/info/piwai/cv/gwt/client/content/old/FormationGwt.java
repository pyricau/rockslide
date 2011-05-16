package info.piwai.cv.gwt.client.content.old;

import info.piwai.cv.gwt.client.content.old.clientbundle.ClientBundle;
import info.piwai.cv.gwt.client.content.old.development_mode.DevelopmentMode;
import info.piwai.cv.gwt.client.content.old.environnement_dev.EnvironnementDev;
import info.piwai.cv.gwt.client.content.old.events.Events;
import info.piwai.cv.gwt.client.content.old.introduction.Introduction;
import info.piwai.cv.gwt.client.content.old.outil_avances.OutilsAvances;
import info.piwai.cv.gwt.client.content.old.questionnaires.Questionnaires;
import info.piwai.cv.gwt.client.content.old.rpc.RPC;
import info.piwai.cv.gwt.client.content.old.uibinder.UIBinder;
import info.piwai.cv.gwt.client.content.old.welcome.Welcome;
import info.piwai.cv.gwt.client.content.old.widgets.Widgets;
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

public class FormationGwt extends PresentationEntryPoint {

    @UiTemplate("Plan.ui.xml")
    public interface Plan extends UiBinder<Element, ElementSlide> {
        Plan binder = GWT.create(Plan.class);
    }

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Welcome());
        holder.addChapter(new Introduction());
        holder.addChapter(new EnvironnementDev());
        holder.addChapter(new DevelopmentMode());
        holder.addChapter(new Widgets());
        holder.addChapter(new Events());
        holder.addChapter(new RPC());
        holder.addChapter(new UIBinder());
        holder.addChapter(new ClientBundle());
        holder.addChapter(new OutilsAvances());
        holder.addChapter(new Questionnaires());
    }

    @Override
    public void definePreloadedBrushes(List<Brush> brushes) {
        brushes.add(Brushes.JAVA());
        brushes.add(Brushes.XML());
        brushes.add(Brushes.JSCRIPT());
        brushes.add(Brushes.PLAIN());
    }

}
