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

import static info.piwai.rockslide.client.PresentationBuilder.create;
import info.piwai.rockslide.client.res.DocumentationResources;
import info.piwai.rockslide.client.slides.Analytics;
import info.piwai.rockslide.client.ui.Slides;
import info.piwai.rockslide.client.widget.Ribbon;
import info.piwai.rockslide.sh.client.SyntaxHighlighter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.RootPanel;

public class Documentation implements EntryPoint {

	@UiTemplate("Welcome.ui.xml")
	interface Welcome extends UiBinder<Slides, Void> {
		Welcome binder = GWT.create(Welcome.class);
	}

	@UiTemplate("Features.ui.xml")
	interface Features extends UiBinder<Slides, Void> {
		Features binder = GWT.create(Features.class);
	}

	@UiTemplate("GettingStarted.ui.xml")
	interface GettingStarted extends UiBinder<Slides, Void> {
		GettingStarted binder = GWT.create(GettingStarted.class);
	}

	@UiTemplate("Manual.ui.xml")
	interface Manual extends UiBinder<Slides, Void> {
		Manual binder = GWT.create(Manual.class);
	}

	@UiTemplate("History.ui.xml")
	interface History extends UiBinder<Slides, Void> {
		History binder = GWT.create(History.class);
	}

	@UiTemplate("Roadmap.ui.xml")
	interface Roadmap extends UiBinder<Slides, Void> {
		Roadmap binder = GWT.create(Roadmap.class);
	}

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new Ribbon());

		/**
		 * Default options of SyntaxHighlighter
		 */
		SyntaxHighlighter.toolbar = false;

		/**
		 * Will only work if the module info.piwai.rockslide.ga.SlideAnalytics
		 * is imported
		 */
		Analytics.enable("UA-5875795-16");

		create().defaultHeader() //
				.chapter(Welcome.binder) //
				.chapter(Features.binder) //
				.chapter("GettingStarted", "Getting Started", GettingStarted.binder) //
				.chapter(Manual.binder) //
				.chapter(History.binder) //
				.chapter(Roadmap.binder) //
				.presentationCss(DocumentationResources.instance.documentation()) //
				.inject();
	}

}
