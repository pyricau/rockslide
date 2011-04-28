package com.excilys.formation.gwt.client.slider;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public abstract class Chapter {

    private final List<Presentable> slides = new ArrayList<Presentable>();

    public final List<Presentable> getSlides() {
        slides.clear();
        buildSlides();
        return slides;
    }

    protected abstract void buildSlides();

    /**
     * To be used with GWT.create(XXX.class), provided that XXX.class extends
     * UiBinder<Element, ElementSlide>
     * 
     * @param uiBinder
     *            Must be a UiBinder<Element, ElementSlide>. The signature is
     *            Object because GWT.create is generic.
     */
    @SuppressWarnings("unchecked")
    protected final void addSlide(Object uiBinder) {
        addPresentable(new ElementSlide((UiBinder<Element, Object>) uiBinder));
    }

    @SuppressWarnings("unchecked")
    protected final void addNotesSlide(Object uiBinder) {
        addPresentable(new ElementSlideNotes((UiBinder<Element, Object>) uiBinder));
    }

    /**
     * To be used with GWT.create(XXX.class), provided that XXX.class extends
     * UiBinder<Widget, WidgetSlide>
     * 
     * @param uiBinder
     *            Must be a UiBinder<Widget, WidgetSlide>. The signature is
     *            Object because GWT.create is generic.
     */
    @SuppressWarnings("unchecked")
    protected final void addWidgetSlide(Object uiBinder) {
        addPresentable(new WidgetSlide((UiBinder<Widget, Object>) uiBinder));
    }

    /**
     * To be used with GWT.create(XXX.class), provided that XXX.class extends
     * UiBinder<Widget, VisibleSlide>
     * 
     * @param uiBinder
     *            Must be a UiBinder<Widget, VisibleSlide>. The signature is
     *            Object because GWT.create is generic.
     */
    @SuppressWarnings("unchecked")
    protected final void addVisibleSlide(Object uiBinder) {
        addPresentable(new VisibleSlide((UiBinder<Widget, Object>) uiBinder));
    }

    protected final void addPresentable(Presentable presentable) {
        slides.add(presentable);
    }

}
