package info.piwai.cv.gwt.client.content;

import info.piwai.cv.gwt.client.slider.slides.Chapter;

import com.google.gwt.user.client.ui.IsWidget;

public abstract class HeaderChapter extends Chapter {

    private final PresentationHeader presentationHeader;

    public HeaderChapter() {
        presentationHeader = new PresentationHeader();
    }

    @Override
    public IsWidget getHeaderWidget() {
        return presentationHeader;
    }
}
