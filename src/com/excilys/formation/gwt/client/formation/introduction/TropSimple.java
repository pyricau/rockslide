package com.excilys.formation.gwt.client.formation.introduction;

import com.excilys.formation.gwt.client.slider.CodeSlide;
import com.excilys.formation.gwt.client.slider.Presentable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public class TropSimple extends CodeSlide implements Presentable {

    public TropSimple(UiBinder<Widget, CodeSlide> uiBinder) {
        super(uiBinder);
    }

    @UiHandler("button")
    void clicked(ClickEvent e) {
        Window.alert("Mais c'est trop simple !");
    }

}
