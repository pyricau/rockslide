package com.alexgorbatchev.syntaxhighlighter.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

/**
 * Enum designed to hold the set of parameters to be used by the
 * SyntaxHighlighter.
 * 
 * @author Xlorep DarkHelm
 * 
 * @see http://alexgorbatchev.com/SyntaxHighlighter/manual/configuration/#
 *      syntaxhighlighterdefaults
 */
enum Param {

	AUTO_LINKS("auto-links"), CLASS_NAME("class-name"), COLLAPSE("collapse"), FIRST_LINE(
			"first-line"), GUTTER("gutter"), HIGHLIGHT("highlight"), HTML_SCRIPT(
			"html-script"), LIGHT("light"), PAD_LINE_NUMBERS("pad-line-numbers"), QUICK_CODE(
			"quick-code"), SMART_TABS("smart-tabs"), TAB_SIZE("tab-size"), TOOLBAR(
			"toolbar"), TITLE("title");
	/**
	 * The literal string used in the SyntaxHighlighter for this parameter.
	 */
	private final String jsString;

	/**
	 * @param jsString
	 *            {@link #jsString}
	 */
	private Param(String jsString) {
		this.jsString = jsString;
	}

	/**
	 * 
	 * @return {@link #jsString}
	 */
	final String getJsString() {
		return jsString;
	}

	/**
	 * Makes the string to be used in the {@code <pre>} tag's class attribute
	 * for this parameter. If the value is equal to the default value, then the
	 * string returned will be empty.
	 * 
	 * @param value
	 *            this parameter's value.
	 * @return the string to be generated.
	 */
	private final String makeString(String value) {
		if (isDefault(value)) {
			return "";
		} else {
			return jsString + ": " + value + ";";
		}
	}

	/**
	 * Tests to see if the given value is equal to the default value for this
	 * parameter.
	 * 
	 * @param value
	 *            the value to test.
	 * @return true = is equal to the default, false = is not equal.
	 */
	private final boolean isDefault(String value) {
		return isDefault(this, value);
	}

	/**
	 * Tests to see if the given value is equal to the default value for the
	 * given parameter.
	 * 
	 * @param param
	 *            the parameter to test.
	 * @param value
	 *            the value to test.
	 * @return true = is equal to the default, false = is not equal.
	 */
	private static final boolean isDefault(Param param, String value) {
		return param.getDefault().equals(value);
	}

	/**
	 * 
	 * @return the default for this parameter.
	 */
	private final String getDefault() {
		String ret = null;
		ret = getDefault(jsString);
		return ret;
	}

	/**
	 * The logger instance for the Param enum.
	 */
	private static final Logger log = Logger.getLogger(Param.class.getName());

	/**
	 * JSNI method to get the default for the parameter.
	 * @param param the {@link #jsString} for the parameter to look up.
	 * @return the default value for the given parameter.
	 */
	private static final native String getDefault(String param)
	/*-{
		var dVal = $wnd.SyntaxHighlighter.defaults[param];
		var strVal = String(dVal);
		if(dVal instanceof Object && dVal.constructor == Array) {
			strVal = '[' + strVal + ']';
		}
		return strVal;
	}-*/;

	/**
	 * Gets a map of the entire set of defaults for every parameter.
	 * @return the map of defaults.
	 */
	static final Map<Param, String> getDefaults() {
		log.finest("Getting the defaults for SyntaxHighlighter parameters.");
		Map<Param, String> ret = new HashMap<Param, String>();
		for (Param param : values()) {
			ret.put(param, param.getDefault());
		}
		return ret;
	}

	/**
	 * Makes the entire string to be used as part of the {@code <pre>} tag's class, for
	 * all parameters defined in the given map.
	 * 
	 * @param params the map of parameters to generate the string for.
	 * @return the string to be used.
	 */
	static final String makeString(Map<Param, String> params) {
		StringBuilder builder = new StringBuilder();
		for (Entry<Param, String> entry : params.entrySet()) {
			if (builder.length() > 0) {

				builder.append(" ");
			}
			builder.append(entry.getKey().makeString(entry.getValue()));
		}
		return builder.toString();
	}
}
