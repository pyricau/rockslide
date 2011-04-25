package com.excilys.formation.gwt.client.slider;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;

public abstract class Chapter {

    private final List<Presentable> slides = new ArrayList<Presentable>();

    public final List<Presentable> getSlides() {
        buildSlides();
        return slides;
    }

    protected abstract void buildSlides();

    /**
     * To be used with GWT.create(XXX.class), provided that XXX.class extends
     * UiBinder<Element, Slide>
     * 
     * @param uiBinder
     *            Must be a UiBinder<Element, Slide>. The signature is Object
     *            because GWT.create is generic.
     */
    @SuppressWarnings("unchecked")
    protected final void addSlide(Object uiBinder) {
        addPresentable(new ElementSlide((UiBinder<Element, ElementSlide>) uiBinder));
    }

    protected final void addPresentable(Presentable presentable) {
        slides.add(presentable);
    }

}
