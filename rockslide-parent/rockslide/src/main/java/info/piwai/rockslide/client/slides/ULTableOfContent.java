package info.piwai.rockslide.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;

public class ULTableOfContent extends WidgetSlide {

    interface Binder extends UiBinder<Widget, ULTableOfContent> {
    }

    private static final Binder binder = GWT.create(Binder.class);
    
    @UiField
    ULPanel ulPanel;

    public ULTableOfContent(ChapterHolder chapterHolder) {
        super(binder);
        
        for (ChapterName chapterName : chapterHolder.getChapterNames()) {
            String readableName = chapterName.getReadableName();
            String historyName = chapterName.getHistoryName();

            Anchor anchor = new Anchor(readableName);
            anchor.setHref("#" + historyName);

            ulPanel.add(anchor);
        }
    }
    
    @Override
    public String toString() {
        return "TableOfContents";
    }
}
