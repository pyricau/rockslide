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
package info.piwai.rockslide.client.window;

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
