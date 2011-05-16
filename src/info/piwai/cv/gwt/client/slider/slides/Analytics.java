package info.piwai.cv.gwt.client.slider.slides;

import com.google.gwt.core.client.GWT;

public class Analytics {
	
	public static void trackModuleRelativePageView(String page) {
		trackPageView(GWT.getModuleName() + "/" + page);
	}
	
	private static native void trackPageView(String url) /*-{
	  try {
	  		if ($wnd._gat) {
		        // setup tracking object with account
		        var pageTracker = $wnd._gat._getTracker("UA-20749630-1");
		        
		        pageTracker._setRemoteServerMode();
		        
		        // turn on anchor observing
		        pageTracker._setAllowAnchor(true)
		        
		        // send page view to google server
		        pageTracker._trackPageview(url);
	        }
	  } catch(err) {
	  		// Do nothing.
	  }
	}-*/;

}
