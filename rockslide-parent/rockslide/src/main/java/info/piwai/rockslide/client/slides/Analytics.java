/**
 * Copyright (C) 2011 Pierre-Yves Ricau (py.ricau at gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.piwai.rockslide.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;

public class Analytics {
    
    private static String profileId;
    
    public static void enable(String profileId) {
        Analytics.profileId = profileId;
    }

    public static void trackModuleRelativePageView(String page) {
        if (profileId!=null) {
            trackPageViewAsync(GWT.getModuleName() + "/" + page);
        }
    }

    private static void trackPageViewAsync(final String url) {
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                trackPageView(url, profileId);
            }
        });
    }

    private static native void trackPageView(String url, String profileId) /*-{
		try {
			if ($wnd._gat) {
				// setup tracking object with account
				var pageTracker = $wnd._gat._getTracker(profileId);

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
