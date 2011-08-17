package info.piwai.rockslide.client.slides;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.IsWidget;

public interface Presentable extends IsWidget, Visible, HasHeaderWidget {
    Element getShowNotes();
}
