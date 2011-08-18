package info.piwai.rockslide.sh.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;

/**
 * 
 */
public class Code extends Composite implements HasHTML {

    private HTML panel = new HTML();

    private boolean autoLinks = SyntaxHighlighter.autoLinks;

    private String className = SyntaxHighlighter.className;

    private boolean collapse = SyntaxHighlighter.collapse;

    private int firstLine = SyntaxHighlighter.firstLine;

    private boolean gutter = SyntaxHighlighter.gutter;

    private String highlight = SyntaxHighlighter.highlight;

    private boolean htmlScript = SyntaxHighlighter.htmlScript;

    private boolean smartTabs = SyntaxHighlighter.smartTabs;

    private int tabSize = SyntaxHighlighter.tabSize;

    private boolean toolbar = SyntaxHighlighter.toolbar;

    private JavaScriptObject brush = null;

    @UiConstructor
    public Code() {
        initWidget(panel);
        addStyleName("sh");
    }

    @Override
    public void setHTML(final String html) {

        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                if (brush != null) {
                    String code = html.replaceFirst("<pre>", "").replaceFirst("</pre>", "");
                    String codeAsHtml = SyntaxHighlighter.transform(code, brush, autoLinks, className, collapse, firstLine, gutter, highlight, htmlScript, smartTabs, tabSize, toolbar);
                    panel.setHTML(codeAsHtml);
                }
            }
        });

    }

    @Override
    public String getText() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setText(String text) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getHTML() {
        throw new UnsupportedOperationException();
    }

    public void setAutoLinks(boolean autoLinks) {
        this.autoLinks = autoLinks;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setCollapse(boolean collapse) {
        this.collapse = collapse;
    }

    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    public void setGutter(boolean gutter) {
        this.gutter = gutter;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public void setHtmlScript(boolean htmlScript) {
        this.htmlScript = htmlScript;
    }

    public void setSmartTabs(boolean smartTabs) {
        this.smartTabs = smartTabs;
    }

    public void setTabSize(int tabSize) {
        this.tabSize = tabSize;
    }

    public void setToolbar(boolean toolbar) {
        this.toolbar = toolbar;
    }

    public void setBrush(JavaScriptObject brush) {
        this.brush = brush;
    }

}
