package info.piwai.rockslide.client.slides;

import info.piwai.rockslide.client.slides.Chapter;
import info.piwai.rockslide.client.slides.ChapterHolder;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;

public class PresentationHeader extends Composite {

    public PresentationHeader(ChapterHolder chapterHolder) {
        
        FlowPanel holder = new FlowPanel();
        
        boolean first = true;
        for(Chapter chapter : chapterHolder.getChapters()) {
            if (first) {
                first = false;
            } else {
                InlineLabel separator = new InlineLabel(" | ");
                holder.add(separator);
            }
            
            String readableName = chapter.getReadableName();
            String historyName = chapter.getHistoryName();
            
            Anchor anchor = new Anchor(readableName);
            anchor.setHref("#"+historyName);
            
            holder.add(anchor);
        }
        
        initWidget(holder);
    }

}
