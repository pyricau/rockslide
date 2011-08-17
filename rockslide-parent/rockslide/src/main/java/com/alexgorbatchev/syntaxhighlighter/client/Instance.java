package com.alexgorbatchev.syntaxhighlighter.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * SyntaxHighlighter Instance that contains the highlighted code after the
 * SyntaxHighlighter highlights a configured {@code <pre>} tag element on the
 * page.
 * 
 * @author Xlorep DarkHelm
 * 
 */
class Instance {

	/**
	 * Logger for the Instance class.
	 */
	private static final Logger log = Logger
			.getLogger(Instance.class.getName());
	/**
	 * CSS class name used to change a line of code from highlighted to not
	 * highlighted dynamically.
	 */
	static final String HIGHLIGHTED = "highlighted";
	/**
	 * Highlighter that this Instance belongs to.
	 */
	private final Highlighter highlighter;
	/**
	 * BrushImpl that is used for this Instance.
	 */
	private final BrushImpl brush;
	/**
	 * Code that is highlighted in this Instance.
	 */
	private final String code;
	/**
	 * Parameters used by this Instance.
	 */
	private Map<Param, String> params;
	/**
	 * Element this Instance contains.
	 */
	private Element element;

	/**
	 * Constructor that creates a new Instance.
	 * 
	 * @param highlighter
	 *            {@link #highlighter}
	 * @param params
	 *            {@link #params}
	 * @param brush
	 *            {@link #brush}
	 * @param code
	 *            {@link #code}
	 */
	Instance(Highlighter highlighter, Map<Param, String> params, Brush brush,
			String code) {
		log.finest("Constructing new Instance for Brush \""
				+ brush.getClass().getName() + "\", with Code:\n" + code);
		this.highlighter = highlighter;
		this.brush = BrushImpl.load(brush, getHighlighter());
		this.code = code;
		setParams(params);
	}

	/**
	 * 
	 * @return {@link #brush}
	 */
	Brush getBrush() {
		return brush;
	}

	/**
	 * 
	 * @return {@link #params}
	 */
	Map<Param, String> getParams() {
		return params;
	}

	/**
	 * 
	 * @param params
	 *            {@link #params}
	 */
	private void setParams(Map<Param, String> params) {
		this.params = params;
	}

	/**
	 * Sets a single parameter in the {@link #params} map.
	 * 
	 * @param param
	 *            {@link Param} to be changed.
	 * @param value
	 *            new value for the parameter.
	 */
	private void setParam(Param param, Object value) {
		// String strValue = Param.stringValue(value);
		String strValue = String.valueOf(value);
		if (value.getClass().isArray()) {
			strValue = "[" + strValue + "]";
		}
		getParams().put(param, strValue);
		if (getElement() != null) {
			setHighlighterParam(getElement().getId(), param.getJsString(),
					strValue);
		}
	}

	/**
	 * Gets a single parameter from the {@link #params} map.
	 * 
	 * @param param
	 *            {@link Param} to get.
	 * @return value for the parameter.
	 */
	private String getParam(Param param) {
		return getParams().get(param);
	}

	/**
	 * 
	 * @return {@link #code}
	 */
	String getCode() {
		return code;
	}

	/**
	 * 
	 * @return {@link #element}
	 */
	Element getElement() {
		return element;
	}

	/**
	 * 
	 * @param element
	 *            {@link #element}
	 */
	private void setElement(Element element) {
		this.element = element;
	}

	/**
	 * 
	 * @return {@link #highlighter}
	 */
	private Highlighter getHighlighter() {
		return highlighter;
	}

	/**
	 * Creates the String for the list of parameters to be used in the
	 * {@code <div>} element's class.
	 * 
	 * @return the {@code <div>} element's parameters.
	 */
	private String createParams() {
		String ret = brush + Param.makeString(params);
		return ret;
	}

	/**
	 * @return The {@link Param#AUTO_LINKS} value for this Instance.
	 */
	boolean isAutoLinks() {
		return Boolean.valueOf(getParam(Param.AUTO_LINKS));
	}

	/**
	 * 
	 * @param autoLinks
	 *            The new {@link Param#AUTO_LINKS} value for this Instance.
	 */
	void setAutoLinks(boolean autoLinks) {
		setParam(Param.AUTO_LINKS, autoLinks);
	}

	/**
	 * 
	 * @return The {@link Param#CLASS_NAME} value for this Instance.
	 */
	String getClassName() {
		return getParam(Param.CLASS_NAME);
	}

	/**
	 * 
	 * @param className
	 *            The new {@link Param#CLASS_NAME} value for this Instance.
	 */
	void setClassName(String className) {
		setParam(Param.CLASS_NAME, className);
	}

	/**
	 * 
	 * @return The {@link Param#COLLAPSE} value for this Instance.
	 */
	boolean isCollapse() {
		return Boolean.valueOf(getParam(Param.COLLAPSE));
	}

	/**
	 * 
	 * @param collapse
	 *            The new {@link Param#COLLAPSE} value for this Instance.
	 */
	void setCollapse(boolean collapse) {
		setParam(Param.COLLAPSE, collapse);
	}

	/**
	 * 
	 * @return The {@link Param#FIRST_LINE} value for this Instance.
	 */
	int getFirstLine() {
		return Integer.valueOf(getParam(Param.FIRST_LINE));
	}

	/**
	 * 
	 * @param firstLine
	 *            The new {@link Param#FIRST_LINE} value for this Instance.
	 */
	void setFirstLine(int firstLine) {
		setParam(Param.FIRST_LINE, firstLine);
	}

	/**
	 * 
	 * @return The {@link Param#GUTTER} value for this Instance.
	 */
	boolean isGutter() {
		return Boolean.valueOf(getParam(Param.GUTTER));
	}

	/**
	 * 
	 * @param gutter
	 *            The new {@link Param#GUTTER} value for this Instance.
	 */
	void setGutter(boolean gutter) {
		setParam(Param.GUTTER, gutter);
	}

	/**
	 * 
	 * @return The {@link Param#HIGHLIGHT} value for this Instance as a
	 *         {@literal List<Integer>}.
	 */
	List<Integer> getHighlight() {
		String values = getHighlightString();
		List<Integer> ret = new ArrayList<Integer>();

		if (!values.equals("null")) {
			if (values.indexOf("[") >= 0) {
				String[] items = values.substring(1, values.length() - 1)
						.split(", ");

				for (String item : items) {
					ret.add(Integer.valueOf(item));
				}
			} else {
				ret.add(Integer.valueOf(values));
			}
		}
		return ret;
	}

	/**
	 * 
	 * @return The {@link Param#HIGHLIGHT} value for this Instance as a String.
	 */
	String getHighlightString() {
		return getParam(Param.HIGHLIGHT);
	}

	/**
	 * Sets the {@link Param#HIGHLIGHT} value for this Instance. It can take a
	 * variety of different options as its parameter, and will attempt to
	 * convert it into something useful for the SyntaxHighlighter. It also will
	 * dynamically update the lines in this Instance according to the parameter
	 * it is given, which is dramatically faster than having the
	 * SyntaxHighlighter re-highlight the entire block of code again.
	 * 
	 * @param highlight
	 *            The new {@link Param#HIGHLIGHT} value for this Instance.
	 */
	void setHighlight(Object highlight) {
		final int GUTTER_POS = 0, CODE_POS = 1;

		final String TABLE = "table", TBODY = "tbody", TR = "tr", TD = "td", DIV = "div";

		List<Integer> dels = getHighlight();

		setParam(Param.HIGHLIGHT, highlight);

		List<Integer> adds = getHighlight();

		adds.removeAll(dels);
		dels.removeAll(getHighlight());

		if (getElement() != null) {
			NodeList<Element> parent = getElement().getElementsByTagName(TABLE)
					.getItem(0).getElementsByTagName(TBODY).getItem(0)
					.getElementsByTagName(TR).getItem(0)
					.getElementsByTagName(TD);

			NodeList<Element> gutterLines = parent.getItem(GUTTER_POS)
					.getElementsByTagName(DIV);

			NodeList<Element> codeLines = parent.getItem(CODE_POS)
					.getElementsByTagName(DIV).getItem(0)
					.getElementsByTagName(DIV);

			for (int lineNo : adds) {
				Element cLine = codeLines.getItem(lineNo - 1);
				Element gLine = gutterLines.getItem(lineNo - 1);

				cLine.addClassName(HIGHLIGHTED);
				gLine.addClassName(HIGHLIGHTED);
			}

			for (int lineNo : dels) {
				Element cLine = codeLines.getItem(lineNo - 1);
				Element gLine = gutterLines.getItem(lineNo - 1);

				cLine.removeClassName(HIGHLIGHTED);
				gLine.removeClassName(HIGHLIGHTED);
			}
		}
	}

	/**
	 * 
	 * @return The {@link Param#HTML_SCRIPT} value for this Instance.
	 */
	boolean isHtmlScript() {
		return Boolean.valueOf(getParam(Param.HTML_SCRIPT));
	}

	/**
	 * 
	 * @param htmlScript
	 *            The new {@link Param#HTML_SCRIPT} value for this Instance.
	 */
	void setHtmlScript(boolean htmlScript) {
		setParam(Param.HTML_SCRIPT, htmlScript);
		if (htmlScript) {
			BrushImpl.load(Brush.Brushes.XML(), getHighlighter());
		}
	}

	/**
	 * 
	 * @return The {@link Param#SMART_TABS} value for this Instance.
	 */
	boolean isSmartTabs() {
		return Boolean.valueOf(getParam(Param.SMART_TABS));
	}

	/**
	 * 
	 * @param smartTabs
	 *            The new {@link Param#SMART_TABS} value for this Instance.
	 */
	void setSmartTabs(boolean smartTabs) {
		setParam(Param.SMART_TABS, smartTabs);
	}

	/**
	 * 
	 * @return The {@link Param#TAB_SIZE} value for this Instance.
	 */
	int getTabSize() {
		return Integer.valueOf(getParam(Param.TAB_SIZE));
	}

	/**
	 * 
	 * @param tabSize
	 *            The new {@link Param#TAB_SIZE} value for this Instance.
	 */
	void setTabSize(int tabSize) {
		setParam(Param.TAB_SIZE, tabSize);
	}

	/**
	 * 
	 * @return The {@link Param#TOOLBAR} value for this Instance.
	 */
	boolean isToolbar() {
		return Boolean.valueOf(getParam(Param.TOOLBAR));
	}

	/**
	 * 
	 * @param toolbar
	 *            The new {@link Param#TOOLBAR} value for this Instance.
	 */
	void setToolbar(boolean toolbar) {
		setParam(Param.TOOLBAR, toolbar);
	}

	/**
	 * 
	 * @return The {@link Param#TITLE} value for this Instance.
	 */
	String getTitle() {
		return getParam(Param.TITLE);
	}

	/**
	 * 
	 * @param title
	 *            The new {@link Param#TITLE} value for this Instance.
	 */
	void setTitle(String title) {
		setParam(Param.TITLE, title);
	}

	/**
	 * Compares this Instance with another Object to determine equality. Returns
	 * true if and only if the other object is another Instance, and the
	 * {@link #brush} and {@link #code} are equal.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Instance other = (Instance) obj;
		if (this.brush != other.brush
				&& (this.brush == null || !this.brush.equals(other.brush))) {
			return false;
		}
		if ((this.code == null) ? (other.code != null) : !this.code
				.equals(other.code)) {
			return false;
		}
		return true;
	}

	/**
	 * Generates the hashcode for this Instance, using the {@link #brush} and
	 * {@link #code} in the hash generation.
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 23 * hash + (this.brush != null ? this.brush.hashCode() : 0);
		hash = 23 * hash + (this.code != null ? this.code.hashCode() : 0);
		return hash;
	}

	/**
	 * Attempts to highlight this Instance. For the highlighting to work, the Instance's
	 * {@link #brush} must be {@link BrushImpl#isLoaded() loaded}, the Instance can't
	 * already be highlighted, and there must be {@link #code} to be highlighted. Once
	 * the Instance is highlighted, the resulting Element created by the SyntaxHighlighter
	 * is attached as the {@link #element} for this Instance. 
	 */
	void highlight() {
		log.finest("Attempting to highlight Instance.");
		if (brush.isLoaded() && getElement() == null && getCode() != null
				&& getCode().trim().length() > 0) {
			getHighlighter().makePre(createParams(), getCode());

			log.finest("Calling $wnd.SyntaxHighlighter.highlight()");
			Element newElement = getHighlighter().getElement()
					.getFirstChildElement();

			log.finest("Element: \"" + newElement.getTagName() + "\"; ID: \""
					+ newElement.getId() + "\"; Class: \""
					+ newElement.getClassName() + "\"\n" + newElement);

			doHighlight();

			newElement = getHighlighter().getElement().getFirstChildElement();

			log.finest("Element: \"" + newElement.getTagName() + "\"; ID: \""
					+ newElement.getId() + "\"; Class: \""
					+ newElement.getClassName() + "\"\n" + newElement);
			if (newElement.hasChildNodes()
					&& newElement.getFirstChildElement().getId()
							.startsWith("highlighter_")) {
				log.finest("Getting highlighted Element for later.");
				setElement(newElement.getFirstChildElement());

				log.finest("Adding this Instance to the list of existing Instances for the Highlighter.");
				getHighlighter().add(Instance.this);
				getHighlighter().replElement(getElement());
				Highlighter.setHighlighting(false);
			} else {
				log.finest("Failed to highlight Element.");
			}
		} else {
			Highlighter.setHighlighting(false);
			String logData = "Cannot highlight Instance, because:";
			if (!brush.isLoaded()) {
				logData += "\n* Brush isn't loaded yet.";
			}
			if (getElement() != null) {
				logData += "\n* Instance is already highlighted.";
			}
			if (getCode() == null || getCode().trim().length() == 0) {
				logData += "\n* Code is "
						+ (getCode() == null ? "null" : "empty") + ".";
			}
			log.finest(logData);
		}
	}

	/**
	 * JSNI method to set the parameter for the SyntaxHighlighter.
	 * 
	 * @param id ID of the highlighter element on the page.
	 * @param param {@link Param#getJsString() JavaScript String} parameter name to be set.
	 * @param value the parameter's new value to be set to.
	 */
	private static native void setHighlighterParam(String id, String param,
			String value)
	/*-{
		$wnd.SyntaxHighlighter.vars['highlighters'][id].params[param] = value;
	}-*/;

	/**
	 * JSNI method to perform a highlight of the Instance(s) that need to be highlighted.
	 */
	private static native void doHighlight()
	/*-{
		$wnd.SyntaxHighlighter.highlight();
	}-*/;
}
