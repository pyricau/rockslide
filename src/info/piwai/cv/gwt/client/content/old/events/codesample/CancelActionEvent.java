package info.piwai.cv.gwt.client.content.old.events.codesample;

import com.google.gwt.event.shared.GwtEvent;

public class CancelActionEvent extends GwtEvent<CancelActionHandler> {

    private static final Type<CancelActionHandler> TYPE = new Type<CancelActionHandler>();

    @Override
    protected void dispatch(CancelActionHandler handler) {
        handler.onCancelAction(this);
    }

    @Override
    public GwtEvent.Type<CancelActionHandler> getAssociatedType() {
        return TYPE;
    }

}
