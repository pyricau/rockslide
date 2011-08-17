package info.piwai.rockslide.client.welcome;

import info.piwai.rockslide.client.slides.WidgetSlide;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class JobOffers extends WidgetSlide {

    @UiTemplate("JobOffers.ui.xml")
    interface Binder extends UiBinder<Widget, JobOffers> {
        Binder binder = GWT.create(Binder.class);
    }

    public JobOffers() {
        super(Binder.binder);
    }

    @UiHandler("description")
    void clicked(ClickEvent e) {

        DialogBox dialogBox = new DialogBox();
        DreamJobDescription jobDescription = new DreamJobDescription(dialogBox);
        dialogBox.setWidget(jobDescription);
        dialogBox.setText("My Dream Job description");
        dialogBox.setAutoHideEnabled(false);
        dialogBox.setAnimationEnabled(true);
        dialogBox.setAutoHideOnHistoryEventsEnabled(true);
        dialogBox.setGlassEnabled(true);

        dialogBox.center();
    }
}
