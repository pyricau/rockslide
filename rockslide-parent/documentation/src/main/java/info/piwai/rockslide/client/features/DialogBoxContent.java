package info.piwai.rockslide.client.features;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class DialogBoxContent extends Composite {

    interface Binder extends UiBinder<Widget, DialogBoxContent> {}

    private static final Binder binder = GWT.create(Binder.class);

    private final PopupPanel closable;

    public DialogBoxContent(PopupPanel closable) {
        this.closable = closable;
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("closeButton")
    void onCloseClick(ClickEvent e) {
        closable.hide();
    }
}

