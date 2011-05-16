package info.piwai.cv.gwt.client.content.old.introduction;

import info.piwai.cv.gwt.client.slider.shownotes.WidgetSlideNotes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public class TropSimple extends WidgetSlideNotes {

    @UiTemplate("TropSimple.ui.xml")
    interface Binder extends UiBinder<Widget, TropSimple> {
        Binder binder = GWT.create(Binder.class);
    }

    public TropSimple() {
        super(Binder.binder);
    }

    @UiHandler("button")
    void clicked(ClickEvent e) {
        Window.alert("Mais c'est trop simple !");
    }
}
