package info.piwai.rockslide.md.client.ui;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHTML;

public class Markdown extends Composite implements HasHTML {
    
    public static String convertMarkdownToHTML(String text) {
        String html = convertMarkdownToHTMLJS(text);
        return html.replaceAll("&amp;", "&");
    }
    
    private static native String convertMarkdownToHTMLJS(String text) /*-{
    var converter = new $wnd.Showdown.converter();
    return converter.makeHtml(text);
}-*/;

    private HTML panel = new HTML();

    @UiConstructor
    public Markdown() {
        initWidget(panel);
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

    @Override
    public void setHTML(String text) {
        text = text.replaceFirst("<pre>", "").replaceFirst("</pre>", "");
        String html = convertMarkdownToHTML(text);
        panel.setHTML(html);
    }

}
