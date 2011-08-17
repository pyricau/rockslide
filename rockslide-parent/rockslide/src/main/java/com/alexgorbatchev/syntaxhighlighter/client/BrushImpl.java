package com.alexgorbatchev.syntaxhighlighter.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Base implementation class for the {@link Brush) interface, used by the {
 * @link com.alexgorbatchev.syntaxhighlighter.compiler.BrushGenerator
 * BrushGenerator}.
 * 
 * @author Xlorep DarkHelm
 * 
 * @see http://code.google.com/webtoolkit/doc/latest/DevGuideClientBundle.html#
 *      TextResource
 */
class BrushImpl implements Brush {

	/**
	 * The logger for the BrushImpl.
	 */
	private static final Logger log = Logger.getLogger(BrushImpl.class
			.getName());
	/**
	 * Used in the id field for the @code(<script>) element which is created when the
	 * BrushImpl's script is loaded.
	 */
	private static final String ID_PREFIX = "SyntaxHighlighter:Brush:";
	/**
	 * List of BrushImpls that are currently asynchronously loading their scripts.
	 */
	private static final List<BrushImpl> loadingList = new ArrayList<BrushImpl>();
	/**
	 * true = script is loaded, false = script is not currently loaded.
	 */
	private boolean loaded;
	/**
	 * The alias that will be used for this brush.
	 */
	private final String alias;
	/**
	 * The JavaScript resource that will be loaded for this script.
	 */
	private final ExternalTextResource script;

	/**
	 * Constructor
	 * 
	 * @param alias
	 *            the alias to use for this Brush.
	 * @param script
	 *            the javascript file for this Brush.
	 * 
	 */
	BrushImpl(String alias, ExternalTextResource script) {
		log.finer("Constructing Brush \"" + this.getClass().getName()
				+ "\", with alias of \"" + alias + "\", using script \""
				+ script + "\"");
		this.alias = alias;
		this.script = script;
		setLoaded(false);
	}

	/**
	 * 
	 * @return the JavaScript file for this Brush.
	 */
	private ExternalTextResource getScript() {
		return script;
	}

	/**
	 * 
	 * @return true = JavaScript file has been loaded for this Brush, false =
	 *         not loaded yet.
	 */
	final boolean isLoaded() {
		return loaded;
	}

	/**
	 * 
	 * @param loaded
	 *            sets whether this Brush's JavaScript file has been loaded yet.
	 */
	void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	/**
	 * Loads the JavaScript file for a given Brush.
	 * 
	 * @param brush
	 *            the Brush to be loaded.
	 * @param high
	 *            the Highlighter that made the request to load the Brush.
	 * @return The BrushImpl after it has started to load.
	 */
	final static BrushImpl load(final Brush brush, final Highlighter high) {
		BrushImpl brushImpl = (BrushImpl) brush;

		brushImpl.load(high);

		return brushImpl;
	}

	/**
	 * Loads the JavaScript file for this Brush.
	 * 
	 * @param high
	 *            the Highlighter that made the request to load the Brush.
	 */
	private final void load(final Highlighter high) {
		if (isLoaded() || loadingList.contains(this)) {
			if (isLoaded()) {
				log.finest("Brush already loaded.");
			} else {
				log.finest("Brush is currently being loaded.");
			}
			return;
		}
		try {
			log.finest("Loading Brush...");
			loadingList.add(this);
			getScript().getText(new ResourceCallback<TextResource>() {

				public void onSuccess(TextResource script) {
					if (!isLoaded()) {
						log.finest("Brush loaded. Inserting JavaScript into document.");
						Document document = Document.get();
						HeadElement head = (HeadElement) document
								.getElementsByTagName("head").getItem(0);
						ScriptElement element = document
								.createScriptElement(script.getText());
						element.setId(ID_PREFIX + getAlias());
						element.setType("text/javascript");
						head.appendChild(element);

						setLoaded(true);
						loadingList.remove(BrushImpl.this);

						if (loadingList.size() == 0) {
							log.finest("Telling SyntaxHighlighter to highlight now.");
							high.highlight();
						} else {
							log.finest("More Brushes are loading, waiting for them to finish before highlighting.");
						}
					}
				}

				public void onError(ResourceException e) {
					throw new UnsupportedOperationException(
							"Not supported yet.");
				}
			});
		} catch (ResourceException ex) {
			// Do nothing
		}
	}

	/**
	 * Converts the Brush to a string that can be used in the SyntaxHighlighter
	 * class name (for setting up a new highlighter).
	 */
	@Override
	public final String toString() {
		String ret = "brush: " + getAlias() + "; ";
		return ret;
	}

	/**
	 * Compares this BrushImpl with another object. They are equal if and only if
	 * the other object is a BrushImpl instance and its script equals this BrushImpl's
	 * script.
	 */
	@Override
	public final boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final BrushImpl other = (BrushImpl) obj;
		if (this.script != other.script
				&& (this.script == null || !this.script.equals(other.script))) {
			return false;
		}
		return true;
	}

	/**
	 * Generates the hash code for this BrushImpl, using its script to calculate the hash.
	 */
	@Override
	public final int hashCode() {
		int hash = 5;
		hash = 37 * hash + (this.script != null ? this.script.hashCode() : 0);
		return hash;
	}

	/**
	 * 
	 * @return the alias that will be used for this Brush.
	 */
	final String getAlias() {
		return alias;
	}
}
