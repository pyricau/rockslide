/**
 * Copyright (C) 2011 Pierre-Yves Ricau (py.ricau at gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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
