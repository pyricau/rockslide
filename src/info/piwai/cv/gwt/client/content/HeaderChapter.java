package info.piwai.cv.gwt.client.content;

import info.piwai.cv.gwt.client.slider.slides.Chapter;

import com.google.gwt.user.client.ui.IsWidget;

public abstract class HeaderChapter extends Chapter {

    private static PresentationHeader presentationHeader;

    public HeaderChapter() {
        if (presentationHeader == null) {
            presentationHeader = new PresentationHeader();
        }
    }

    @Override
    public IsWidget getHeaderWidget() {
        return presentationHeader;
    }
}
