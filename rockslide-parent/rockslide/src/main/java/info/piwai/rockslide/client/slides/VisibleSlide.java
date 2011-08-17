package info.piwai.rockslide.client.slides;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

public class VisibleSlide extends WidgetSlide implements Presentable {

    @UiField
    public Visible visibleWidget;

    public VisibleSlide(UiBinder<?, ?> uiBinder) {
        super(uiBinder);
    }

    @Override
    public void visible() {
        visibleWidget.visible();
    }
}
