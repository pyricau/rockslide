package com.excilys.formation.gwt.client.slider.window;

import com.google.gwt.core.client.JavaScriptObject;

public class WindowHelper {

    public static native JavaScriptObject openWindow(String url, String name, String features) /*-{
		return $wnd.open(url, name, features);
    }-*/;

    public static native void sendMessage(JavaScriptObject wnd, String listenerName, Object arg) /*-{
		if (wnd[listenerName]) {
			wnd[listenerName](arg);
		}
    }-*/;

    public static native void sendMessage(String listenerName, Object arg) /*-{
		if ($wnd[listenerName]) {
			$wnd[listenerName](arg);
		}
    }-*/;

    public static native void registerListener(String listenerName, WindowMessageListener<?> listener) /*-{
		$wnd[listenerName] = function(arg) {
			listener.@com.excilys.formation.gwt.client.slider.window.WindowMessageListener::onMessage(Ljava/lang/Object;)(arg);
		};
    }-*/;

    public static native void registerListener(JavaScriptObject wnd, String listenerName, WindowMessageListener<?> listener) /*-{
		wnd[listenerName] = function(arg) {
			listener.@com.excilys.formation.gwt.client.slider.window.WindowMessageListener::onMessage(Ljava/lang/Object;)(arg);
		};
    }-*/;

}
