package info.piwai.cv.gwt.client.slider.slides;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;

public interface Presentable extends IsWidget, Visible, HasHeaderWidget {
    Element getShowNotes();
}
