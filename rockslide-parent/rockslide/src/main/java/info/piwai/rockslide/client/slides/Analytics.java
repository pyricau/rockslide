package info.piwai.rockslide.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

public class Analytics {

    public static void trackModuleRelativePageView(String page) {
        trackPageViewAsync(GWT.getModuleName() + "/" + page);
    }

    private static void trackPageViewAsync(final String url) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                trackPageView(url);
            }
        });
    }

    // TODO add configurable analytics tracker
    private static native void trackPageView(String url) /*-{
		try {
			if ($wnd._gat) {
				// setup tracking object with account
				var pageTracker = $wnd._gat._getTracker("UA-5875795-15");

				pageTracker._setRemoteServerMode();

				// turn on anchor observing
				pageTracker._setAllowAnchor(true)

				// send page view to google server
				pageTracker._trackPageview(url);
			}
		} catch (err) {
			// Do nothing.
		}
    }-*/;

}
