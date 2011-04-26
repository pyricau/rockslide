package com.excilys.formation.gwt.client.formation.introduction;

import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
import com.excilys.formation.gwt.client.slider.Presentable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.PreElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TropSimple extends Composite implements Presentable {

    interface Binder extends UiBinder<Widget, TropSimple> {}

    private static final Binder uiBinder = GWT.create(Binder.class);

    @UiField
    Highlighter sourceCode;

    @UiField
    PreElement codeSample;

    public TropSimple() {
        initWidget(uiBinder.createAndBindUi(this));
        sourceCode.setText(codeSample.getInnerText());
    }

    @UiHandler("button")
    void clicked(ClickEvent e) {
        Window.alert("Mais c'est trop simple !");
    }

}
