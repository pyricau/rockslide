package info.piwai.rockslide.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;

public class LoadingWidget extends Widget {

    private static Binder uiBinder = GWT.create(Binder.class);

    interface Binder extends UiBinder<Element, LoadingWidget> {}

    interface Style extends CssResource {
        String hidden();
    }

    @UiField
    Style style;

    @UiField
    DivElement slowLoading;

    public LoadingWidget() {
        setElement(uiBinder.createAndBindUi(this));
    }

    public void showSlowLoadingWarning() {
        slowLoading.removeClassName(style.hidden());
    }
}
