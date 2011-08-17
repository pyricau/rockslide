package com.alexgorbatchev.syntaxhighlighter.client;

import com.google.gwt.resources.client.CssResource;

/**
 * Base class that defines a Theme to be loaded.
 * 
 * @author Xlorep DarkHelm
 * 
 */
abstract class Theme {
	/**
	 * The CssResource for this Theme.
	 */
	private final CssResource style;

	/**
	 * Constructor for the Theme.
	 * 
	 * @param style
	 *            {@link #style}
	 */
	Theme(CssResource style) {
		this.style = style;
	}

	/**
	 * Pass-through method to {@link CssResource#ensureInjected()
	 * style.ensureInjected()}.
	 * 
	 * @return
	 */
	public final boolean ensureInjected() {
		return style.ensureInjected();
	}
}
