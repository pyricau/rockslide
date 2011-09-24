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
import info.piwai.rockslide.client.slides.Chapter;
import info.piwai.rockslide.client.slides.HeaderWidget;
import info.piwai.rockslide.client.slides.PresentationHeader;
import info.piwai.rockslide.client.slides.SlideViewer;
import info.piwai.rockslide.client.ui.Slides;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Window.Location;

public final class PresentationBuilder {

	public static final String SHOW_NOTES_PARAM = "showNotes";

	private final List<Chapter> chapters = new ArrayList<Chapter>();
	
	private final List<CssResource> presentationCssResources = new ArrayList<CssResource>();

    private HeaderWidget header;

	public PresentationBuilder header(HeaderWidget header) {
		this.header = header;
		return this;
	}
	
	public PresentationBuilder defaultHeader() {
		return header(new PresentationHeader());
	}
	
	public PresentationBuilder chapter(Chapter chapter) {
		chapters.add(chapter);
		return this;
	}
	
	public PresentationBuilder chapter(String historyName, String readableName, UiBinder<Slides, Void> slideDefinitions) {
		Chapter chapter = new Chapter();
		
		chapter.setSlideDefinitions(slideDefinitions);
		chapter.setHistoryName(historyName);
		chapter.setReadableName(readableName);
		
		return chapter(chapter);
	}
	
	public PresentationBuilder chapter(UiBinder<Slides, Void> slideDefinitions) {
		return chapter(null, slideDefinitions);
	}
	
	public PresentationBuilder chapter(String name, UiBinder<Slides, Void> slideDefinitions) {
		return chapter(name, name, slideDefinitions);
	}
		
	public PresentationBuilder presentationCss(CssResource cssResource) {
		presentationCssResources.add(cssResource);
		return this;
	}

	HeaderWidget getHeaderWidget() {
		return header;
	}

	public void inject() {
		String showNotes = Location.getParameter(SHOW_NOTES_PARAM);
		if ("true".equals(showNotes)) {
			ShowNotesViewer showNotesViewer = new ShowNotesViewer();
			showNotesViewer.load();
		} else {
			for(CssResource cssResource : presentationCssResources) {
				cssResource.ensureInjected();
			}
			SlideViewer slideViewer = new SlideViewer();
			slideViewer.load(chapters, header);
		}
	}
	
	public static PresentationBuilder create() {
		return new PresentationBuilder();
	}
	

}