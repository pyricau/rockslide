package com.excilys.formation.gwt.client.slider;

import java.util.HashMap;
import java.util.Map;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
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

    private static Map<Brush, Highlighter> highlighters = new HashMap<Brush, Highlighter>();

    private static Highlighter getHighlighter(Brush brush) {
        if (!highlighters.containsKey(brush)) {
            highlighters.put(brush, new Highlighter(brush));
        }
        return highlighters.get(brush);
    }

    private final Brush brush;

    private String code;

    private final SimplePanel panel = new SimplePanel();

    @UiConstructor
    public CodeHighlighter(Brush brush) {
        this.brush = brush;
        initWidget(panel);
    }

    public void visible() {
        Highlighter highlighter = getHighlighter(brush);
        SimplePanel parent = (SimplePanel) highlighter.getParent();
        if (parent != panel) {
            if (parent != null) {
                parent.clear();
            }
            highlighter.setText(code);
            panel.setWidget(highlighter);
        }
    }

    @Override
    public void setHTML(String html) {
        code = html.replaceAll("<pre>", "").replaceAll("</pre>", "");
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

}
