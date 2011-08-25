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
package info.piwai.rockslide.client.ui;

import info.piwai.rockslide.client.slides.SlidePresentable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class Slides extends Composite implements HasWidgets {

    private final List<SlidePresentable> slides = new ArrayList<SlidePresentable>();

    @Override
    public void add(Widget w) {
        if (! (w instanceof SlidePresentable)) {
            return;
        }
        SlidePresentable slide = (SlidePresentable) w;
        
        slides.add(slide);
    }
    
    public List<SlidePresentable> getSlides() {
        return slides;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Widget> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Widget w) {
        throw new UnsupportedOperationException();
    }

}
