package info.piwai.cv.gwt.client.content;

import info.piwai.cv.gwt.client.slider.slides.Presentable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class WIP extends Widget implements Presentable {

    interface Binder extends UiBinder<Element, WIP> {}

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    SpanElement header;

    public WIP(String title) {
        setElement(binder.createAndBindUi(this));
        header.setInnerText(title);
    }

    @Override
    public void visible() {
    }

    @Override
    public IsWidget getHeaderWidget() {
        return null;
    }

    @Override
    public Element getShowNotes() {
        return null;
    }

}
