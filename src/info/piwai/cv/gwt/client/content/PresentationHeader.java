package info.piwai.cv.gwt.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ScriptElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class PresentationHeader extends Widget {

    interface Binder extends UiBinder<Element, PresentationHeader> {}

    private static final Binder binder = GWT.create(Binder.class);

    public PresentationHeader() {
        Element headerElement = binder.createAndBindUi(this);

        String plusOneButton = "<g:plusone href=\"http://cv.piwai.info\"></g:plusone>";
        String innerHTML = headerElement.getInnerHTML();
        headerElement.setInnerHTML(plusOneButton + innerHTML);

        setElement(headerElement);

        Document doc = Document.get();
        ScriptElement script = doc.createScriptElement();
        script.setSrc("https://apis.google.com/js/plusone.js");
        script.setType("text/javascript");
        script.setLang("javascript");
        doc.getBody().appendChild(script);

    }

}
