package info.piwai.rockslide.client.features;

import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class ClassicGWT extends WidgetSlide {


    interface Binder extends UiBinder<Widget, ClassicGWT> {
        Binder binder = GWT.create(Binder.class);
    }

    public ClassicGWT() {
        super(Binder.binder);
    }

    @UiHandler("button")
    void clicked(ClickEvent e) {

        DialogBox dialogBox = new DialogBox();
        DialogBoxContent content = new DialogBoxContent(dialogBox);
        dialogBox.setWidget(content);
        dialogBox.setText("I can haz popups?");
        dialogBox.setAutoHideEnabled(false);
        dialogBox.setAnimationEnabled(true);
        dialogBox.setAutoHideOnHistoryEventsEnabled(true);
        dialogBox.setGlassEnabled(true);
        
        dialogBox.center();
    }

}
