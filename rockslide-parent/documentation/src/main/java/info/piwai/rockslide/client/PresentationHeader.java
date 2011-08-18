package info.piwai.rockslide.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class PresentationHeader extends Widget {

    interface Binder extends UiBinder<Element, PresentationHeader> {}

    private static final Binder binder = GWT.create(Binder.class);

    public PresentationHeader() {
        setElement(binder.createAndBindUi(this));
    }

}
