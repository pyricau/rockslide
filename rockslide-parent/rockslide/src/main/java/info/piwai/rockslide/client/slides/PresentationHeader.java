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
package info.piwai.rockslide.client.slides;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;

public class PresentationHeader extends Composite implements HeaderWidget {

    private FlowPanel holder;

	public PresentationHeader() {
        holder = new FlowPanel();
        initWidget(holder);
    }

	@Override
	public void init(TableOfContent tableOfContent) {
        boolean first = true;
        for (ChapterName chapterName : tableOfContent.getChapterNames()) {
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
	}

}
