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
package info.piwai.rockslide.client;

import info.piwai.rockslide.client.features.Features;
import info.piwai.rockslide.client.gettingstarted.GettingStarted;
import info.piwai.rockslide.client.history.History;
import info.piwai.rockslide.client.roadmap.Roadmap;
import info.piwai.rockslide.client.slides.Analytics;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.PresentationHeader;
import info.piwai.rockslide.client.welcome.Welcome;
import info.piwai.rockslide.sh.client.SyntaxHighlighter;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;

public class Documentation extends PresentationEntryPoint {

    private PresentationHeader header;

    @Override
    public void initSlides() {
        
        RootPanel.get().add(new Ribbon());

        /**
         * Custom CSS injection
         */
        DocumentationResources.instance.documentation().ensureInjected();

        /**
         * Default options of SyntaxHighlighter
         */
        SyntaxHighlighter.toolbar = false;

        /**
         * Will only work if the module info.piwai.rockslide.ga.SlideAnalytics
         * is imported
         */
        Analytics.enable("UA-5875795-16");
    }

    @Override
    public void loadChapters(ChapterHolder holder) {
        holder.addChapter(new Welcome());
        holder.addChapter(new Features());
        holder.addChapter(new GettingStarted());
        holder.addChapter(new History());
        holder.addChapter(new Roadmap());
        
        header = new PresentationHeader(holder);
    }
    
    @Override
    public IsWidget getHeaderWidget() {
        return header;
    }

}
