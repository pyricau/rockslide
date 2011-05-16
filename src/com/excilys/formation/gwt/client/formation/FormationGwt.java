package com.excilys.formation.gwt.client.formation;

import java.util.List;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes;
import com.excilys.formation.gwt.client.formation.clientbundle.ClientBundle;
import com.excilys.formation.gwt.client.formation.development_mode.DevelopmentMode;
import com.excilys.formation.gwt.client.formation.environnement_dev.EnvironnementDev;
import com.excilys.formation.gwt.client.formation.events.Events;
import com.excilys.formation.gwt.client.formation.introduction.Introduction;
import com.excilys.formation.gwt.client.formation.outil_avances.OutilsAvances;
import com.excilys.formation.gwt.client.formation.questionnaires.Questionnaires;
import com.excilys.formation.gwt.client.formation.rpc.RPC;
import com.excilys.formation.gwt.client.formation.uibinder.UIBinder;
import com.excilys.formation.gwt.client.formation.welcome.Welcome;
import com.excilys.formation.gwt.client.formation.widgets.Widgets;
import com.excilys.formation.gwt.client.slider.PresentationEntryPoint;
import com.excilys.formation.gwt.client.slider.slides.ChapterHolder;
import com.excilys.formation.gwt.client.slider.slides.ElementSlide;
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
