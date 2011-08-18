package info.piwai.rockslide.sh.java.client;

import com.google.gwt.core.client.JavaScriptObject;

public class JavaSH {
    
    public native JavaScriptObject brush() /*-{
        return new $wnd.SyntaxHighlighter.brushes.Java();
    }-*/;
    
    

}
