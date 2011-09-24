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

import info.piwai.rockslide.client.slides.TableOfContent;
import info.piwai.rockslide.client.ui.Slide;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.ui.HTML;

public class MDSlide extends Slide {

    public MDSlide(String html) {
        super(html);
    }
    
    @Override
    public void init(TableOfContent tableOfContent) {
        extractPreToMarkdown();
        
        com.google.gwt.user.client.Element element = getElement();
        int childCount = element.getChildCount();

        for (int i = 0; i < childCount; i++) {
            Node child = element.getChild(i);
            if ("MDNOTES".equals(child.getNodeName().toUpperCase())) {
                notes = Element.as(child);
                notes.removeFromParent();
                break;
            }
        }
        
        if (notes != null) {
        	String markdownHTML = notes.getInnerHTML();
        	markdownHTML = markdownHTML.replaceFirst("<pre>", "").replaceFirst("</pre>", "");
            String realHTML = Markdown.convertMarkdownToHTML(markdownHTML);
            notes.setInnerHTML(realHTML);
        }
        
        super.init(tableOfContent);
    }

    private void extractPreToMarkdown() {
        com.google.gwt.user.client.Element element = getElement();
        
        for (int i = 0; i< element.getChildCount(); i++) {
            Node child = element.getChild(i);
            if ("PRE".equals(child.getNodeName().toUpperCase())) {
                Element pre = Element.as(child);
                
                String markdownHTML = pre.getInnerHTML();
                String realHTML = Markdown.convertMarkdownToHTML(markdownHTML);
                com.google.gwt.user.client.Element htmlElement = new HTML(realHTML).getElement();
                
                int htmlChildCount = htmlElement.getChildCount();
                for(int j=0; j<htmlChildCount; j++) {
                    Node htmlChild = htmlElement.getFirstChild();
                    element.insertBefore(htmlChild, child);
                }
                
                i+=htmlChildCount;
                
                pre.removeFromParent();
                i-=1;
            }
        }
    }



}
