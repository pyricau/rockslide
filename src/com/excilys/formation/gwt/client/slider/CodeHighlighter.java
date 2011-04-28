package com.excilys.formation.gwt.client.slider;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * See http://code.google.com/p/gwt-syntaxhighlighter/issues/detail?id=11
 * 
 * This trick is used to use only one Highlighter for each brush at a time.
 * 
 * The defaults values are mapped to
 * http://alexgorbatchev.com/SyntaxHighlighter/manual/configuration/
 */
public class CodeHighlighter extends Composite implements HasHTML {

    private static boolean highlightersDisabled = false;

    public static void disableHighlighters() {
        highlightersDisabled = true;
    }

    private String text;

    private SimplePanel panel = new SimplePanel();

    private boolean autoLinks = true;

    private String className = "";

    private boolean collapse = false;

    private int firstLine = 1;

    private boolean gutter = true;

    private Object highlight = "null";

    private boolean htmlScript = false;

    private boolean smartTabs = true;

    private int tabSize = 4;

    private boolean toolbar = true;

    private String title = "";

    @UiConstructor
    public CodeHighlighter(final Brush brush) {
        initWidget(panel);
        if (!highlightersDisabled) {
            /*
             * We must create the highlighter after all properties have been
             * injected. I didn't any widget callback in UiBinder to do so...
             * Let's use a ScheduledCommand!
             */
            Scheduler.get().scheduleDeferred(new ScheduledCommand() {
                @Override
                public void execute() {
                    HighlighterLoader.get().addHighlightedWidget(brush, CodeHighlighter.this);
                }
            });
        }
    }

    void prepareHighlighter(Highlighter highlighter) {
        panel.setWidget(highlighter);

        highlighter.setAutoLinks(autoLinks);
        highlighter.setClassName(className);
        highlighter.setCollapse(collapse);
        highlighter.setFirstLine(firstLine);
        highlighter.setGutter(gutter);
        highlighter.setHighlight(highlight);
        highlighter.setHtmlScript(htmlScript);
        highlighter.setSmartTabs(smartTabs);
        highlighter.setTabSize(tabSize);
        highlighter.setToolbar(toolbar);
        highlighter.setTitle(title);
        highlighter.setText(text);
    }

    @Override
    public void setHTML(String html) {
        setText(html.replaceFirst("<pre>", "").replaceFirst("</pre>", ""));
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getHTML() {
        return "<pre>" + text + "</pre>";
    }

    /**
     * /** Allows you to turn detection of links in the highlighted element on
     * and off. If the option is turned off, URLs won’t be clickable.
     * 
     * @param autoLinks
     *            true = enabled, false = disabled
     */
    public void setAutoLinks(boolean autoLinks) {
        this.autoLinks = autoLinks;
    }

    /**
     * Allows you to add a custom class (or multiple classes) to every
     * highlighter element that will be created within this Highlighter.
     * 
     * @param className
     *            CSS class names to be added
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Allows you to set whether this Highlighter is collapsed or not.
     * 
     * @param collapse
     *            true = collapsed, false = not collapsed
     */
    public void setCollapse(boolean collapse) {
        this.collapse = collapse;
    }

    /**
     * Allows you to change the first (starting) line number.
     * 
     * @param firstLine
     *            the first line number to be used
     */
    public void setFirstLine(int firstLine) {
        this.firstLine = firstLine;
    }

    /**
     * Allows you to turn gutter with line numbers on and off.
     * 
     * @param gutter
     *            true = has gutter, false = doesn't have gutter
     */
    public void setGutter(boolean gutter) {
        this.gutter = gutter;
    }

    /**
     * Allows you to highlight one or more lines to focus user’s attention. When
     * specifying as a parameter in a UIBinder xml file, you have to pass an
     * array looking value, like [1, 2, 3] or just an number for a single line.
     * When doing this in code, you can pass a string like previously mentioned,
     * or you can pass an array of numbers, a single number, or a collection of
     * numbers as well.
     * 
     * @param highlight
     *            array containing the line numbers to be highlighted
     */
    public void setHighlight(Object highlight) {
        this.highlight = highlight;
    }

    /**
     * Allows you to highlight a mixture of HTML/XML code and a script which is
     * very common in web development. Setting this value to true will load the
     * XML brush, and requires that the brush you are using supports this
     * feature.
     * 
     * @param htmlScript
     *            true = enable, false = disable
     */
    public void setHtmlScript(boolean htmlScript) {
        this.htmlScript = htmlScript;
    }

    /**
     * Allows you to turn smart tabs feature on and off.
     * 
     * @param smartTabs
     *            true = smart tabs on, false = smart tabs off
     */
    public void setSmartTabs(boolean smartTabs) {
        this.smartTabs = smartTabs;
    }

    /**
     * Allows you to adjust tab size.
     * 
     * @param tabSize
     *            tab size
     */
    public void setTabSize(int tabSize) {
        this.tabSize = tabSize;
    }

    /**
     * Toggles toolbar on/off.
     * 
     * @param toolbar
     *            true = toolbar on, false = toolbar off
     */
    public void setToolbar(boolean toolbar) {
        this.toolbar = toolbar;
    }

    /**
     * Sets the title to be displayed above the code block.
     * 
     * @param title
     *            the title to be displayed.
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

}
