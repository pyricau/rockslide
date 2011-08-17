package com.alexgorbatchev.syntaxhighlighter.compiler;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;

import com.google.gwt.user.rebind.SourceWriter;

import java.util.Arrays;
import java.util.List;

/**
 * Generates the subclass for the
 * {@link com.alexgorbatchev.syntaxhighlighter.client.Theme Theme} class that is
 * defined according to the syntaxhighlighter.theme property in the
 * {@literal <Module>.gwt.xml} file.
 * 
 * @author Xlorep DarkHelm
 * 
 */
public class ThemeGenerator extends BaseGenerator {

	/**
	 * Fully-qualified class name for the Theme superclass.
	 */
	private static final String SUPER = "com.alexgorbatchev.syntaxhighlighter.client.Theme";
	/**
	 * The list of imports necessary for the Theme subclasses that are
	 * generated.
	 */
	private static final String[] IMPORTS = { "com.google.gwt.core.client.GWT",
			"com.google.gwt.resources.client.ClientBundle",
			"com.google.gwt.resources.client.ClientBundle.Source",
			"com.google.gwt.resources.client.CssResource" };
	/**
	 * The name of the property that defines what theme to use.
	 */
	private static final String PROPERTY = "syntaxhighlighter.theme";

	/**
	 * The list of names for the standard set of themes that come packaged with
	 * SyntaxHighlighter.
	 */
	private static final String[] STANDARD_THEMES = { "Default", "Django",
			"Eclipse", "Emacs", "FadeToGrey", "MDUltra", "Midnight", "RDark" };

	@Override
	protected void generate(SourceWriter writer)
			throws UnableToCompleteException {
		String source = buildPath(getScript());

		log(TreeLogger.INFO, "Setting Theme CSS Source to \"" + source + "\"");

		writer.println("interface Resource extends ClientBundle {");
		writer.indent();
		writer.println("@CssResource.NotStrict");
		writer.println("@Source(\"" + source + "\")");
		writer.println("public CssResource theme();");
		writer.outdent();
		writer.println("}");
		writer.println();
		writer.println("private static final Resource RES = GWT.create(Resource.class);");
		writer.println();
		writer.println("public " + getName() + "() {");
		writer.indent();
		writer.println("super(RES.theme());");
		writer.outdent();
		writer.println("}");
	}

	@Override
	protected String getSuper() {
		return SUPER;
	}

	@Override
	protected String[] getImports() {
		return IMPORTS;
	}

	@Override
	protected String getName() throws UnableToCompleteException {
		return (getSuperName() + '_' + getScript()).replace('.', '_');
	}

	/**
	 * 
	 * @param theme
	 *            The {@value #PROPERTY} value found.
	 * 
	 * @return true if in {@link #STANDARD_THEMES}, false if not.
	 */
	private boolean isStandardTheme(String theme) {
		List<String> standardThemes = Arrays.asList(STANDARD_THEMES);

		return standardThemes.contains(theme);
	}

	/**
	 * Validates that the Generator can find the correct CSS resource for the
	 * generated Theme.
	 * 
	 * @return the filename for the CSS resource file.
	 * 
	 * @throws UnableToCompleteException
	 */
	private String getScript() throws UnableToCompleteException {
		String script = null;

		try {
			String theme = getSelectionProperty(PROPERTY).getCurrentValue();
			if (isStandardTheme(theme)) {
				log(TreeLogger.INFO, "Using Standard Theme: " + theme);
				script = String.format("shTheme%s", theme);
			} else {
				log(TreeLogger.INFO, "Using Extended Theme: " + theme);
				script = theme;
			}
			script += ".css";
		} catch (BadPropertyValueException ex) {
			log(TreeLogger.ERROR, null, ex);

			throw new UnableToCompleteException();
		}

		String scriptPath = getPath(script);

		if (scriptPath != null) {
			log(TreeLogger.INFO, "Theme CSS File: " + scriptPath + script);
		} else {
			log(TreeLogger.ERROR, "Unable to locate Theme CSS file \"" + script
					+ "\".");

			throw new UnableToCompleteException();
		}

		return script;
	}
}
