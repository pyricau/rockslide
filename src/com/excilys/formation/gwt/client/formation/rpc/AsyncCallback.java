package com.excilys.formation.gwt.client.formation.rpc;

import com.excilys.formation.gwt.client.slider.CodeSlide;
import com.excilys.formation.gwt.client.slider.Presentable;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class AsyncCallback extends CodeSlide<AsyncCallback> implements Presentable {

    interface Binder extends UiBinder<Widget, AsyncCallback> {}

    private static final Binder uiBinder = GWT.create(Binder.class);

    public AsyncCallback() {
        super(uiBinder);
    }
}
