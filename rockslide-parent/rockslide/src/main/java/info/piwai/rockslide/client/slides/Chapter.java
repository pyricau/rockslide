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

import info.piwai.rockslide.client.ui.Slides;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.uibinder.client.UiBinder;

public class Chapter implements Iterable<Presentable> {
	
	private List<Presentable> slides;

	private final List<String> slideNames = new ArrayList<String>();

	private UiBinder<Slides, Void> slideDefinitions;

	private String readableName;

	private String historyName;

	final Presentable getSlide(int slideIndex) {
		return slides.get(checkIndex(slideIndex));
	}

	final Presentable getSlideOrNull(int slideIndex) {
		if (slideIndex < 0) {
			return null;
		} else if (slideIndex >= slides.size()) {
			return null;
		}
		return slides.get(slideIndex);
	}

	final int getSlideCount() {
		return slides.size();
	}

	@Override
	public final Iterator<Presentable> iterator() {
		return slides.iterator();
	}

	final boolean isLastSlide(int slideIndex) {
		return checkIndex(slideIndex) == slides.size() - 1;
	}

	final boolean isFirstSlide(int slideIndex) {
		return checkIndex(slideIndex) == 0;
	}

	/**
	 * Unsafe: does not ensure slides
	 */
	final int checkIndex(int index) {
		if (index < 0) {
			index = 0;
		} else if (index >= slides.size()) {
			index = slides.size() - 1;
		}
		return index;
	}

	void loadSlides(TableOfContent tableOfContent) {
		if (slides == null) {
			slides = new ArrayList<Presentable>();
			buildSlides(tableOfContent);
			slides = Collections.unmodifiableList(slides);
		}
	}

	protected void buildSlides(TableOfContent tableOfContent) {
		if (slideDefinitions != null) {
			Slides multiSlide = slideDefinitions.createAndBindUi(null);
			for (SlidePresentable slide : multiSlide.getSlides()) {
				slide.init(tableOfContent);
				addPresentable(slide, slide.getHistoryName());
			}
		}
	}

	private final void addPresentable(Presentable presentable, String historyName) {
		slides.add(presentable);
		String realSlideName;
		historyName = historyName.replace("_", "");

		if (slideNames.contains(historyName)) {
			int i = 1;
			do {
				i++;
				realSlideName = historyName + i;
			} while (slideNames.contains(realSlideName));
		} else {
			realSlideName = historyName;
		}
		slideNames.add(realSlideName);
	}

	/**
	 * May be overriden if you want to change the chapter history name (defaults
	 * to chapter class name)
	 */
	String getHistoryName() {
		if (historyName == null) {
			if (slideDefinitions != null) {
				historyName = ClassHelper.getUiBinderName(slideDefinitions);
			} else {
				historyName = ClassHelper.getSimpleName(getClass());
			}
		}
		return historyName;
	}

	public void setHistoryName(String historyName) {
		this.historyName = historyName;
	}

	/**
	 * May be overriden to change the chapter readable name for table of content
	 * (defaults to history name)
	 */
	String getReadableName() {
		if (readableName != null) {
			return readableName;
		} else {
			return getHistoryName();
		}
	}

	public void setReadableName(String readableName) {
		this.readableName = readableName;
	}

	/**
	 * Returns the slide index.
	 */
	final int getSlideIndex(String slideName) {
		return checkIndex(slideNames.indexOf(slideName));
	}

	final String getSlideName(int slideIndex) {
		return slideNames.get(checkIndex(slideIndex));
	}

	public void setSlideDefinitions(UiBinder<Slides, Void> slideDefinitions) {
		this.slideDefinitions = slideDefinitions;
	}

}
