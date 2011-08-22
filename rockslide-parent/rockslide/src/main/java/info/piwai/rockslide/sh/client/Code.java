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
        addStyleName("rs-code");
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
