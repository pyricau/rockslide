package info.piwai.cv.gwt.client.content.old.development_mode;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

public class CoolButton extends Composite {

    public CoolButton() {
        Button button = new Button("A cool button");
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.alert("Pipopopalopo");
            }
        });

        initWidget(button);
    }

}
