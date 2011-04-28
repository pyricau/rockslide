package com.excilys.formation.gwt.client.slider.window;

import com.google.gwt.core.client.JavaScriptObject;

public class ChildWindow {

    public static ChildWindow open(String url, String name, String features) {
        return new ChildWindow(url, name, features);
    }

    private final JavaScriptObject window;

    private ChildWindow(String url, String name, String features) {
        window = WindowHelper.openWindow(url, name, features);
    }

    public void sendMessage(String listenerName, Object arg) {
        WindowHelper.sendMessage(window, listenerName, arg);
    }

    public void registerListener(String listenerName, WindowMessageListener<?> listener) {
        WindowHelper.registerListener(window, listenerName, listener);
    }

}
