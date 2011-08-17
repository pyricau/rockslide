package info.piwai.rockslide.client.slides;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class WidgetSlide extends Composite implements Presentable {

    public WidgetSlide(UiBinder<?, ?> uiBinder) {
        initWidget(cast(uiBinder).createAndBindUi(this));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static UiBinder<Widget, Object> cast(UiBinder uiBinder) {
        return uiBinder;
    }

    @Override
    public void visible() {
    }

    @Override
    public Element getShowNotes() {
        return null;
    }

    @Override
    public IsWidget getHeaderWidget() {
        return null;
    }
}
