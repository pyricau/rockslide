package info.piwai.cv.gwt.client.content.welcome;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class DreamJobDescription extends Composite {

    interface Binder extends UiBinder<Widget, DreamJobDescription> {}

    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    CheckBox checkbox1;

    @UiField
    CheckBox checkbox2;

    @UiField
    CheckBox checkbox3;

    @UiField
    CheckBox checkbox4;

    @UiField
    Button contactMeButton;

    private final PopupPanel closable;

    public DreamJobDescription(PopupPanel closable) {
        this.closable = closable;
        initWidget(binder.createAndBindUi(this));
        contactMeButton.setEnabled(false);
    }

    @UiHandler({ "checkbox1", "checkbox2", "checkbox3", "checkbox4" })
    void onCheckChange(ValueChangeEvent<Boolean> event) {
        contactMeButton.setEnabled(allCheckboxesChecked());
    }

    private boolean allCheckboxesChecked() {
        return checkbox1.getValue() && checkbox2.getValue() && checkbox3.getValue() && checkbox4.getValue();
    }

    @UiHandler("contactMeButton")
    void onContactClick(ClickEvent e) {
        closable.hide();
        History.newItem("Contact", true);
    }

    @UiHandler("closeButton")
    void onCloseClick(ClickEvent e) {
        closable.hide();
    }
}
