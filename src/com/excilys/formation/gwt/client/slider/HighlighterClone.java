package com.excilys.formation.gwt.client.slider;

import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

public class HighlighterClone extends Widget {

    public static HighlighterClone cloneHighlighter(Highlighter highlighter) {
        return new HighlighterClone(highlighter);
    }

    private HighlighterClone(Highlighter highlighter) {
        Element clone = DOM.clone(highlighter.getElement(), true);
        setElement(clone);
    }

}
