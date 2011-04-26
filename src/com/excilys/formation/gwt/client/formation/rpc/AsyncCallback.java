package com.excilys.formation.gwt.client.formation.rpc;

import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
import com.excilys.formation.gwt.client.slider.Presentable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.PreElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AsyncCallback extends Composite implements Presentable {

    interface Binder extends UiBinder<Widget, AsyncCallback> {}

    private static final Binder uiBinder = GWT.create(Binder.class);

    @UiField
    Highlighter sourceCode;

    @UiField
    PreElement codeSample;

    public AsyncCallback() {
        initWidget(uiBinder.createAndBindUi(this));
        sourceCode.setText(codeSample.getInnerText());
    }
}
