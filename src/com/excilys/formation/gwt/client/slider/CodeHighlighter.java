package com.excilys.formation.gwt.client.slider;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * See http://code.google.com/p/gwt-syntaxhighlighter/issues/detail?id=11
 * 
 * This trick is used to use only one Highlighter at a time.
 */
public class CodeHighlighter extends Composite implements HasHTML {

    private final Brush brush;

    private String code;

    private boolean htmlScript;

    private int tabSize = 4;

    private SimplePanel panel = new SimplePanel();

    private boolean visible;

    @UiConstructor
    public CodeHighlighter(Brush brush) {
        this.brush = brush;
        initWidget(panel);
    }

    public void visible() {
        if (!visible) {
            visible = true;
            HighlighterLoader.get().getHighlightedWidget(panel, brush, code, htmlScript, tabSize);
        }
    }

    @Override
    public void setHTML(String html) {
        code = html.replaceAll("<pre>", "").replaceAll("</pre>", "");
        // code = "//" + htmlScript + " " + tabSize + "\n" + code;
        // Widget highlightedWidget =
        // HighlighterLoader.get().getHighlightedWidget(brush, code, htmlScript,
        // tabSize);
        // initWidget(highlightedWidget);
    }

    // UNUSED

    @Override
    public String getText() {
        return "";
    }

    @Override
    public void setText(String text) {
    }

    @Override
    public String getHTML() {
        return "";
    }

    public void setHtmlScript(boolean htmlScript) {
        this.htmlScript = htmlScript;
    }

    public void setTabSize(int tabSize) {
        this.tabSize = tabSize;
    }

}
