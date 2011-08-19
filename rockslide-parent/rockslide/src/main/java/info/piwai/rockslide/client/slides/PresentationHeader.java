package info.piwai.rockslide.client.slides;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;

public class PresentationHeader extends Composite {

    public PresentationHeader(ChapterHolder chapterHolder) {

        FlowPanel holder = new FlowPanel();

        boolean first = true;
        for (ChapterName chapterName : chapterHolder.getChapterNames()) {
            if (first) {
                first = false;
            } else {
                InlineLabel separator = new InlineLabel(" | ");
                holder.add(separator);
            }

            String readableName = chapterName.getReadableName();
            String historyName = chapterName.getHistoryName();

            Anchor anchor = new Anchor(readableName);
            anchor.setHref("#" + historyName);

            holder.add(anchor);
        }

        initWidget(holder);
    }

}
