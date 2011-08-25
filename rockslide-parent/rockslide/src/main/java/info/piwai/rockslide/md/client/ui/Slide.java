package info.piwai.rockslide.md.client.ui;

import info.piwai.rockslide.client.slides.SlidePresentable;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HTML;

public class Slide extends Markdown implements SlidePresentable {
    

    private String historyId = "Slide";

    private HTML panel = new HTML();

    @UiConstructor
    public Slide() {
        initWidget(panel);
    }

    @Override
    public Element getShowNotes() {
        return null;
    }

    @Override
    public void visible() {

    }

    @Override
    public String getHistoryName() {
        return historyId;
    }

    @Override
    public void extractShowNotes() {

    }

    public void setHid(String historyId) {
        historyId = historyId.trim();
        if (!"".equals(historyId)) {
            this.historyId = historyId;
        }
    }

}
