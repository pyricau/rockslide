package info.piwai.rockslide.sh.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Using SyntaxHighlighter 3.0.83 (http://alexgorbatchev.com/SyntaxHighlighter)
 */
public class SyntaxHighlighter {

    /**
     * Allows you to turn detection of links in the highlighted element on and
     * off. If the option is turned off, URLs won’t be clickable.
     */
    public static boolean autoLinks = true;

    /**
     * Allows you to add a custom class (or multiple classes) to every
     * highlighter element that will be created on the page.
     */
    public static String className = "";

    /**
     * Allows you to force highlighted elements on the page to be collapsed by
     * default.
     */
    public static boolean collapse = false;

    /**
     * Allows you to change the first (starting) line number.
     */
    public static int firstLine = 1;

    /**
     * Allows you to turn gutter with line numbers on and off.
     */
    public static boolean gutter = true;

    /**
     * Allows you to highlight one or more lines to focus user’s attention. Can
     * be null, or "5". The "[1, 2, 3]" syntax is not working yet.
     */
    public static String highlight = null;

    /**
     * Allows you to highlight a mixture of HTML/XML code and a script which is
     * very common in web development. Setting this value to true requires that
     * you have shBrushXml.js loaded and that the brush you are using supports
     * this feature.
     */
    public static boolean htmlScript = false;

    /**
     * Allows you to turn smart tabs feature on and off.
     */
    public static boolean  smartTabs = true;
    
    /**
     *  Allows you to adjust tab size.
     */
    public static int tabSize = 4;
    
    /**
     * Toggles toolbar on/off.
     */
    public static boolean toolbar = true;

    public static native String transform(String code, JavaScriptObject brush, boolean autoLinksP, String classNameP, boolean collapseP, int firstLineP, boolean gutterP, String highlightP, boolean htmlScriptP, boolean smartTabsP, int tabSizeP, boolean toolbarP) /*-{
        var params = {};
        
        params['auto-links'] = autoLinksP;
        params['class-name'] = classNameP;
        params['collapse'] = collapseP;
        params['first-line'] = firstLineP;
        params['gutter'] = gutterP;
        params['highlight'] = highlightP;
        params['html-script'] = htmlScriptP;
        params['smart-tabs'] = smartTabsP;
        params['tabSize'] = tabSizeP;
        params['toolbar'] = toolbarP;
           
        brush.init(params);
           
        return brush.getHtml(code);
    }-*/;
    
}
