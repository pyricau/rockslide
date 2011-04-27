package com.excilys.formation.gwt.client.slider;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Frame;

public class DelayedFrame extends Frame implements Presentable {

    public String url;

    private boolean visible = false;

    public DelayedFrame() {
        super();
    }

    public DelayedFrame(String url) {
        super(url);
    }

    protected DelayedFrame(Element element) {
        super(element);
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void visible() {
        if (!visible && url != null) {
            visible = true;
            super.setUrl(url);
        }
    }

}
