package com.alexgorbatchev.syntaxhighlighter.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.PreElement;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * <p>
 * Main Widget to use in order to create a SyntaxHighlighter object within GWT.
 * It can be instantiated with the constructor
 * {@link #Highlighter(com.alexgorbatchev.syntaxhighlighter.client.Brush)
 * Highlighter(Brush brush)}, or it can be used with UiBinder as follows:
 * </p>
 * 
 * <blockquote>
 * 
 * <pre>
 * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
 *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
 *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
 *              >
 *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
 * 
 *     {@literal <syntax:Highlighter ui:field="sourceCode" brushes="{brush.PLAIN}"/>}
 * {@literal </ui:UiBinder>}
 * </pre>
 * 
 * </blockquote>
 * 
 * @author Xlorep DarkHelm
 * @see <a target="_blank"
 *      href="http://code.google.com/webtoolkit/doc/latest/DevGuideUiBinder.html"
 *      >GWT: Declarative Layout with UiBinder</a>
 * @see Brush.Brushes
 */
public class Highlighter extends Widget implements HasText {

	/**
	 * The logger instance for the Highlighter.
	 */
	private static final Logger log = Logger.getLogger(Highlighter.class
			.getName());
	/**
	 * True = currently highlighting; false = not currently highlighting.
	 */
	private static boolean highlighting = false;

	/**
	 * List of {@link Instance highlighter instances} created by this
	 * Highlighter.
	 */
	private final List<Instance> highlighters;
	/**
	 * The current {@link Instance} being shown on this Highlighter.
	 */
	private Instance currentInstance;

	/**
	 * Constructs a Highlighter object with the given Brush.
	 * 
	 * @param brush
	 *            the Brush to use.
	 */
	@UiConstructor
	public Highlighter(Brush brush) {
		highlighters = new ArrayList<Instance>();
		setElement(Document.get().createDivElement());

		log.finer("Creating new Highlighter instance with Brush \""
				+ brush.getClass().getName() + "\".");
		setInstance(brush, "");
	}

	/**
	 * 
	 * @return the current Instance for this Highlighter.
	 */
	private Instance get() {
		return currentInstance;
	}

	/**
	 * Returns whether detection of links in the highlighted element is on or
	 * off. If the option is turned off, URLs won’t be clickable.
	 * 
	 * @return true = enabled, false = disabled
	 */
	public boolean isAutoLinks() {
		return get().isAutoLinks();
	}

	/**
	 * Allows you to turn detection of links in the highlighted element on and
	 * off. If the option is turned off, URLs won’t be clickable.
	 * 
	 * @param autoLinks
	 *            true = enabled, false = disabled
	 */
	public void setAutoLinks(boolean autoLinks) {
		get().setAutoLinks(autoLinks);
	}

	/**
	 * Returns the custom class (or multiple classes) that is/are applied to
	 * every highlighter element that is created within this Highlighter.
	 * 
	 * @return CSS class names to be added
	 */
	public String getClassName() {
		return get().getClassName();
	}

	/**
	 * Allows you to add a custom class (or multiple classes) to every
	 * highlighter element that will be created within this Highlighter.
	 * 
	 * @param className
	 *            CSS class names to be added
	 */
	public void setClassName(String className) {
		get().setClassName(className);
	}

	/**
	 * Returns whether the Highlighter is collapsed or not.
	 * 
	 * @return true = collapsed, false = not collapsed
	 */
	public boolean isCollapse() {
		return get().isCollapse();
	}

	/**
	 * Allows you to set whether this Highlighter is collapsed or not.
	 * 
	 * @param collapse
	 *            true = collapsed, false = not collapsed
	 */
	public void setCollapse(boolean collapse) {
		get().setCollapse(collapse);
	}

	/**
	 * Returns the first (starting) number that is used by this Highlighter.
	 * 
	 * @return the first line number
	 */
	public int getFirstLine() {
		return get().getFirstLine();
	}

	/**
	 * Allows you to change the first (starting) line number.
	 * 
	 * @param firstLine
	 *            the first line number to be used
	 */
	public void setFirstLine(int firstLine) {
		get().setFirstLine(firstLine);
	}

	/**
	 * Returns whether the gutter with line numbers is on or off.
	 * 
	 * @return true = has gutter, false = doesn't have gutter
	 */
	public boolean isGutter() {
		return get().isGutter();
	}

	/**
	 * Allows you to turn gutter with line numbers on and off.
	 * 
	 * @param gutter
	 *            true = has gutter, false = doesn't have gutter
	 */
	public void setGutter(boolean gutter) {
		get().setGutter(gutter);
	}

	/**
	 * Returns a {@literal List<Integer>} of line numbers to highlight.
	 * 
	 * @return list containing the line numbers to highlight
	 */
	public List<Integer> getHighlight() {
		return get().getHighlight();
	}

	/**
	 * Returns a String of line numbers to highlight, using the format of
	 * comma-separated numbers, with square brackets surrounding the whole set
	 * like: [1, 2, 3]
	 * 
	 * @return String containing the line numbers to highlight
	 */
	public String getHighlightString() {
		return get().getHighlightString();
	}

	/**
	 * Allows you to highlight one or more lines to focus user’s attention.
	 * When specifying as a parameter in a UIBinder xml file, you have to pass
	 * an array looking value, like [1, 2, 3] or just an number for a single
	 * line. When doing this in code, you can pass a string like previously
	 * mentioned, or you can pass an array of numbers, a single number, or a
	 * collection of numbers as well.
	 * 
	 * @param highlight
	 *            array containing the line numbers to be highlighted
	 */
	public void setHighlight(Object highlight) {
		get().setHighlight(highlight);
	}

	/**
	 * Returns whether the feature to highlight a mixture of HTML/XML code and a
	 * script, which is very common in web development, is enabled or disabled.
	 * 
	 * @return true = enabled, false = disabled
	 */
	public boolean isHtmlScript() {
		return get().isHtmlScript();
	}

	/**
	 * Allows you to highlight a mixture of HTML/XML code and a script which is
	 * very common in web development. Setting this value to true will load the
	 * XML brush, and requires that the brush you are using supports this
	 * feature.
	 * 
	 * @param htmlScript
	 *            true = enable, false = disable
	 */
	public void setHtmlScript(boolean htmlScript) {
		get().setHtmlScript(htmlScript);
	}

	/**
	 * Returns whether the smart tabs feature is on or off.
	 * 
	 * @return true = smart tabs on, false = smart tabs off
	 */
	public boolean isSmartTabs() {
		return get().isSmartTabs();
	}

	/**
	 * Allows you to turn smart tabs feature on and off.
	 * 
	 * @param smartTabs
	 *            true = smart tabs on, false = smart tabs off
	 */
	public void setSmartTabs(boolean smartTabs) {
		get().setSmartTabs(smartTabs);
	}

	/**
	 * Returns the tab size.
	 * 
	 * @return tab size
	 */
	public int getTabSize() {
		return get().getTabSize();
	}

	/**
	 * Allows you to adjust tab size.
	 * 
	 * @param tabSize
	 *            tab size
	 */
	public void setTabSize(int tabSize) {
		get().setTabSize(tabSize);
	}

	/**
	 * Returns whether the toolbar is on or off.
	 * 
	 * @return true = toolbar on, false = toolbar off
	 */
	public boolean isToolbar() {
		return get().isToolbar();
	}

	/**
	 * Toggles toolbar on/off.
	 * 
	 * @param toolbar
	 *            true = toolbar on, false = toolbar off
	 */
	public void setToolbar(boolean toolbar) {
		get().setToolbar(toolbar);
	}

	/**
	 * Sets the title to be displayed above the code block.
	 * 
	 * @param title
	 *            the title to be displayed.
	 */
	@Override
	public void setTitle(String title) {
		currentInstance.setTitle(title);
	}

	/**
	 * Gets the title that is displayed above the code block.
	 * 
	 * @return the title of the code block.
	 */
	@Override
	public String getTitle() {
		return currentInstance.getTitle();
	}

	/**
	 * Sets the current Instance for this Highlighter, either by finding an
	 * instance that already exists in the {@link #highlighters} list, or
	 * creating an entirely new Instance.
	 * 
	 * @param brush
	 *            the Brush to use for this Instance.
	 * @param text
	 *            the code to use for this Instance.
	 */
	private void setInstance(final Brush brush, final String text) {
		String logData = "Attempting to locate existing Highlighter instance.";
		Instance instance = null;
		for (Instance item : highlighters) {
			if (item.getCode().equals(text) && item.getBrush().equals(brush)) {
				instance = item;
				break;
			}
		}
		if (instance != null) {
			logData += "\nHighlighter instance found.";
			currentInstance = instance;
		} else {
			logData += "\nCreating new Highlighter instance.";
			Map<Param, String> params = null;
			if (get() == null) {
				params = Param.getDefaults();
			} else {
				params = get().getParams();
			}
			currentInstance = new Instance(this, params, brush, text);
		}

		log.finest(logData);

		if (get().getElement() == null) {
			highlight();
		} else {
			replElement(get().getElement());
		}
	}

	/**
	 * Gets the Brush used for this highlighter.
	 * 
	 * @return the Brush.
	 * @see com.alexgorbatchev.syntaxhighlighter.client.Brush
	 */
	public Brush getBrush() {
		return get().getBrush();
	}

	/**
	 * Gets the source code for this Highlighter.
	 * 
	 * @return the current source code.
	 */
	public String getText() {
		return get().getCode();
	}

	/**
	 * Sets the source code for this Highlighter.
	 * 
	 * @param text
	 *            the source code to use.
	 */
	public void setText(String text) {
		if (text != null && text.trim().length() > 0
				&& !text.equals(get().getCode())) {
			setInstance(getBrush(), text);
		}
	}

	/**
	 * Adds a new Instance to the {@link #highlighters} list.
	 * 
	 * @param instance
	 *            the Instance to be added.
	 */
	void add(Instance instance) {
		highlighters.add(instance);
	}

	/**
	 * Replaces this Highlighter's Element with a new Element.
	 * 
	 * @param element
	 *            The Element to set this Highlighter to use.
	 */
	void replElement(final Element element) {
		if (getElement().hasChildNodes()) {
			getElement().replaceChild(element, getElement().getFirstChild());
		} else {
			getElement().appendChild(element);
		}
	}

	/**
	 * Creates the {@code <pre>} tag that will be used to make the
	 * SyntaxHighlighter highlight the code.
	 * 
	 * @param params the parameters to set as the {@code <pre>} tag's class attribute.
	 * @param code the code to place in the {@code <pre>} tag to be highlighter.
	 */
	void makePre(String params, String code) {
		PreElement pre = Document.get().createPreElement();
		log.finest("Preparing for highlighting using class=\"" + params
				+ "\", for code:\n" + code);
		if (Window.Navigator.getUserAgent().contains("msie")) {
			code = code.replace("\r\n", "\n").replace("\n", "\r\n");
		}
		pre.setInnerHTML(code.replace("<", "&lt;"));
		pre.setClassName(params);
		replElement(pre);
		log.finest("\nClass for Element = \""
				+ getElement().getFirstChildElement().getClassName()
				+ "\"\nCode: \n"
				+ getElement().getFirstChildElement().getInnerHTML());
	}

	/**
	 * Highlights the current instance, if possible.
	 */
	void highlight() {
		log.finest("Telling Instance to try and highlight.");
		if (!isHighlighting()) {
			setHighlighting(true);
			get().highlight();
		} else {
			String logData = "Highlighting failed.";
			logData += "\n* Already trying to highlight Instance.";

			log.finest(logData);
		}
	}

	/**
	 * 
	 * @param highlighting true = currently highlighting this Highlighter, false = not highlighting.
	 */
	static void setHighlighting(boolean highlighting) {
		Highlighter.highlighting = highlighting;
	}

	/**
	 * 
	 * @return true = currently highlighting this Highlighter, false = not highlighting.
	 */
	private static boolean isHighlighting() {
		return highlighting;
	}

	/**
	 * Tests to see if this Highlighter is equal to some other Object. The other
	 * Object must be a Highlighter, and have the same Brush & code set for it
	 * to be true.
	 * 
	 * @param obj
	 *            the object to test equality with.
	 * @return true if equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Highlighter other = (Highlighter) obj;
		if (this.currentInstance != other.currentInstance
				&& (this.currentInstance == null || !this.currentInstance
						.equals(other.currentInstance))) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the hash code for this Highlighter, based on the Brush and code
	 * for this Highlighter.
	 * 
	 * @return the hashcode.
	 */
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 53
				* hash
				+ (this.currentInstance != null ? this.currentInstance
						.hashCode() : 0);
		return hash;
	}
}
