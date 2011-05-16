package info.piwai.cv.gwt.client.content.old.uibinder.codesample;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Cool extends Composite {

    private static CoolBinder uiBinder = GWT.create(CoolBinder.class);

    interface CoolBinder extends UiBinder<Widget, Cool> {}

    @UiField
    Button button;

    @UiField
    DivElement coolDiv;

    public Cool() {
        initWidget(uiBinder.createAndBindUi(this));
        coolDiv.setInnerText("Coool");
    }

    @UiHandler("button")
    void coolClick(ClickEvent e) {
        Window.alert("Salut !");
    }
}
