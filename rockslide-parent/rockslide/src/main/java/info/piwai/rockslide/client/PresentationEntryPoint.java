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

import info.piwai.rockslide.client.shownotes.ShowNotesViewer;
import info.piwai.rockslide.client.slides.ChapterHolder;
import info.piwai.rockslide.client.slides.SlideViewer;
import info.piwai.rockslide.client.slides.TableOfContentFactory;
import info.piwai.rockslide.client.slides.UlTableOfContentFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.IsWidget;

public abstract class PresentationEntryPoint implements EntryPoint, PresentationBuilder {

    public static final String SHOW_NOTES_PARAM = "showNotes";

    public void initSlides() {
    }

    public void initNotes() {
    }

    @Override
    public final void onModuleLoad() {
        String showNotes = Location.getParameter(SHOW_NOTES_PARAM);
        if ("true".equals(showNotes)) {
            initNotes();
            ShowNotesViewer showNotesViewer = new ShowNotesViewer();
            showNotesViewer.load();
        } else {
            initSlides();
            SlideViewer slideViewer = new SlideViewer(PresentationEntryPoint.this);
            slideViewer.load();
        }
    }

    @Override
    public IsWidget getHeaderWidget() {
        return null;
    }

    /**
     * May be overriden to provide other implementations of
     * PresentationMapFactory
     */
    @Override
    public TableOfContentFactory buildTableOfContentFactory(ChapterHolder chapterHolder) {
        return new UlTableOfContentFactory(chapterHolder);
    }

}
