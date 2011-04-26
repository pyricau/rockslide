package com.excilys.formation.gwt.client.slider;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CodeSlide<T extends CodeSlide<T>> extends Composite implements Presentable {

    @UiField
    public CodeHighlighter sourceCode;

    public CodeSlide(UiBinder<Widget, T> uiBinder) {
        initWidget(uiBinder.createAndBindUi(castThis()));
    }

    @SuppressWarnings("unchecked")
    public T castThis() {
        return (T) this;
    }

    @Override
    public void visible() {
        sourceCode.visible();
    }
}
