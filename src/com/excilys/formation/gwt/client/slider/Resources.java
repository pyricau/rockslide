package com.excilys.formation.gwt.client.slider;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface Resources extends ClientBundle {

    public static final Resources instance = GWT.create(Resources.class);

    @NotStrict
    CssResource main();

}
