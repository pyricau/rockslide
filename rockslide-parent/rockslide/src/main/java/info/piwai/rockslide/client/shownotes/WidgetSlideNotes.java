package info.piwai.rockslide.client.shownotes;

import info.piwai.rockslide.client.slides.Presentable;
import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

public class WidgetSlideNotes extends WidgetSlide implements Presentable {

    @UiField
    public Element notes;

    public WidgetSlideNotes(UiBinder<?, ?> uiBinder) {
        super(uiBinder);
        notes.removeFromParent();
    }

    @Override
    public Element getShowNotes() {
        return notes;
    }
}
