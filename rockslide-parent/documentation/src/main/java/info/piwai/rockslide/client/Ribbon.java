package info.piwai.rockslide.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class Ribbon extends Widget{
    
    interface Binder extends UiBinder<Element, Ribbon> {
    }
    
    private static final Binder binder = GWT.create(Binder.class);
    
    public Ribbon() {
        setElement(binder.createAndBindUi(this));
    }

}
