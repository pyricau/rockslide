package info.piwai.rockslide.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.CssResource.NotStrict;

public interface DocumentationResources extends ClientBundle {
    
    public static final DocumentationResources instance = GWT.create(DocumentationResources.class);
    
    ImageResource headerLogo();
    
    @NotStrict
    CssResource documentation();

}
