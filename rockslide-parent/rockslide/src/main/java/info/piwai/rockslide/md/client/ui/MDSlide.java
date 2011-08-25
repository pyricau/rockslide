package info.piwai.rockslide.md.client.ui;

import info.piwai.rockslide.client.ui.Slide;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.ui.HTML;

public class MDSlide extends Slide {

    public MDSlide(String html) {
        super(html);
    }
    
    @Override
    public void transform() {
        extractPreToMarkdown();
        
        super.transform();
    }

    private void extractPreToMarkdown() {
        com.google.gwt.user.client.Element element = getElement();
        int childCount = element.getChildCount();
        
        for (int i = 0; i< childCount; i++) {
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
