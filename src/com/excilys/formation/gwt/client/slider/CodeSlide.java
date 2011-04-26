package com.excilys.formation.gwt.client.slider;

import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
import com.google.gwt.dom.client.PreElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CodeSlide extends Composite implements Presentable {

    @UiField
    public Highlighter sourceCode;

    @UiField
    public PreElement codeSample;

    public CodeSlide(UiBinder<Widget, CodeSlide> uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        sourceCode.setText(codeSample.getInnerText());
    }

}
