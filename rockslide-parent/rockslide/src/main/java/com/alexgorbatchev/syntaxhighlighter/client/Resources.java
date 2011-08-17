package com.alexgorbatchev.syntaxhighlighter.client;

import com.google.gwt.core.client.GWT;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadElement;
import com.google.gwt.dom.client.ScriptElement;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.GwtCreateResource;
import com.google.gwt.resources.client.GwtCreateResource.ClassType;
import com.google.gwt.resources.client.TextResource;
import java.util.logging.Logger;

/**
 * ClientBundle for the gwt-syntaxhighlighter project.
 * 
 * @author Xlorep DarkHelm
 * 
 */
interface Resources extends ClientBundle {

	/**
	 * Instance to be used by everything in the gwt-syntaxhighlighter project.
	 */
	public final Resources INSTANCE = new Init();

	/**
	 * The core SyntaxHighlighter JavaScript resource.
	 * 
	 * @return The TextResource for the core JavaScript file.
	 */
	@Source(Paths.CORE + "shCore.js")
	TextResource coreScript();

	/**
	 * The core SyntaxHighlighter CSS resource.
	 * 
	 * @return The TextResource for the core CSS file.
	 */
	@CssResource.NotStrict
	@Source(Paths.CORE + "shCore.css")
	CssResource coreStyle();

	/**
	 * The CSS resource that "fixes" the SyntaxHighlighter to render correctly
	 * in GWT.
	 * 
	 * @return The TextResource for the core GWT fixer file.
	 */
	@CssResource.NotStrict
	@Source(Paths.CORE + "shGWTFix.css")
	CssResource GWTFix();

	/**
	 * The {@link Theme} implementation, which is controlled by the
	 * {@link com.alexgorbatchev.syntaxhighlighter.compiler.ThemeGenerator
	 * ThemeGenerator}.
	 * 
	 * @return The GwtCreateResource for the Theme.
	 */
	GwtCreateResource<Theme> theme();

	/**
	 * @return {@link Brushes}
	 */
	Brushes brushes();

	/**
	 * ClientBundle for all of the included Brushes.
	 * 
	 * @author Xlorep DarkHelm
	 */
	interface Brushes extends ClientBundle {

		/**
		 * Used to create the ABL Brush.
		 * 
		 * @return {@link ABL}
		 */
		@ClassType(ABL.class)
		GwtCreateResource<Brush> abl();

		/**
		 * Defines the ABL Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushABL.js")
		interface ABL extends Brush {
		}

		/**
		 * Used to create the AppleScript Brush.
		 * 
		 * @return {@link AppleScript}
		 */
		@ClassType(AppleScript.class)
		GwtCreateResource<Brush> appleScript();

		/**
		 * Defines the AppleScript Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushAppleScript.js")
		interface AppleScript extends Brush {
		}

		/**
		 * Used to create the AS3 Brush.
		 * 
		 * @return {@link AS3}
		 */
		@ClassType(AS3.class)
		GwtCreateResource<Brush> as3();

		/**
		 * Defines the AS3 Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushAS3.js")
		interface AS3 extends Brush {
		}

		/**
		 * Used to create the AU3 Brush.
		 * 
		 * @return {@link AU3}
		 */
		@ClassType(AU3.class)
		GwtCreateResource<Brush> au3();

		/**
		 * Defines the AU3 Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushAutoIt.js")
		interface AU3 extends Brush {
		}

		/**
		 * Used to create the Bash Brush.
		 * 
		 * @return {@link Bash}
		 */
		@ClassType(Bash.class)
		GwtCreateResource<Brush> bash();

		/**
		 * Defines the Bash Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushBash.js")
		interface Bash extends Brush {
		}

		/**
		 * Used to create the CSharp Brush.
		 * 
		 * @return {@link CSharp}
		 */
		@ClassType(CSharp.class)
		GwtCreateResource<Brush> cSharp();

		/**
		 * Defines the CSharp Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushCSharp.js")
		interface CSharp extends Brush {
		}

		/**
		 * Used to create the ColdFusion Brush.
		 * 
		 * @return {@link ColdFusion}
		 */
		@ClassType(ColdFusion.class)
		GwtCreateResource<Brush> coldFusion();

		/**
		 * Defines the ColdFusion Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushColdFusion.js")
		interface ColdFusion extends Brush {
		}

		/**
		 * Used to create the Cpp Brush.
		 * 
		 * @return {@link Cpp}
		 */
		@ClassType(Cpp.class)
		GwtCreateResource<Brush> cpp();

		/**
		 * Defines the Cpp Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushCpp.js")
		interface Cpp extends Brush {
		}

		/**
		 * Used to create the Css Brush.
		 * 
		 * @return {@link Css}
		 */
		@ClassType(Css.class)
		GwtCreateResource<Brush> css();

		/**
		 * Defines the Css Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushCss.js")
		interface Css extends Brush {
		}

		/**
		 * Used to create the Delphi Brush.
		 * 
		 * @return {@link Delphi}
		 */
		@ClassType(Delphi.class)
		GwtCreateResource<Brush> delphi();

		/**
		 * Defines the Delphi Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushDelphi.js")
		interface Delphi extends Brush {
		}

		/**
		 * Used to create the Diff Brush.
		 * 
		 * @return {@link Diff}
		 */
		@ClassType(Diff.class)
		GwtCreateResource<Brush> diff();

		/**
		 * Defines the Diff Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushDiff.js")
		interface Diff extends Brush {
		}

		/**
		 * Used to create the Erlang Brush.
		 * 
		 * @return {@link Erlang}
		 */
		@ClassType(Erlang.class)
		GwtCreateResource<Brush> erlang();

		/**
		 * Defines the Erlang Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushErlang.js")
		interface Erlang extends Brush {
		}

		/**
		 * Used to create the Groovy Brush.
		 * 
		 * @return {@link Groovy}
		 */
		@ClassType(Groovy.class)
		GwtCreateResource<Brush> groovy();

		/**
		 * Defines the Groovy Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushGroovy.js")
		interface Groovy extends Brush {
		}

		/**
		 * Used to create the JScript Brush.
		 * 
		 * @return {@link JScript}
		 */
		@ClassType(JScript.class)
		GwtCreateResource<Brush> jScript();

		/**
		 * Defines the JScript Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushJScript.js")
		interface JScript extends Brush {
		}

		/**
		 * Used to create the Java Brush.
		 * 
		 * @return {@link Java}
		 */
		@ClassType(Java.class)
		GwtCreateResource<Brush> java();

		/**
		 * Defines the Java Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushJava.js")
		interface Java extends Brush {
		}

		/**
		 * Used to create the JavaFX Brush.
		 * 
		 * @return {@link JavaFX}
		 */
		@ClassType(JavaFX.class)
		GwtCreateResource<Brush> javaFX();

		/**
		 * Defines the JavaFX Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushJavaFX.js")
		interface JavaFX extends Brush {
		}

		/**
		 * Used to create the Lisp Brush.
		 * 
		 * @return {@link Lisp}
		 */
		@ClassType(Lisp.class)
		GwtCreateResource<Brush> lisp();

		/**
		 * Defines the Lisp Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushLisp.js")
		interface Lisp extends Brush {
		}

		/**
		 * Used to create the Perl Brush.
		 * 
		 * @return {@link Perl}
		 */
		@ClassType(Perl.class)
		GwtCreateResource<Brush> perl();

		/**
		 * Defines the Perl Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushPerl.js")
		interface Perl extends Brush {
		}

		/**
		 * Used to create the Php Brush.
		 * 
		 * @return {@link Php}
		 */
		@ClassType(Php.class)
		GwtCreateResource<Brush> php();

		/**
		 * Defines the Php Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushPhp.js")
		interface Php extends Brush {
		}

		/**
		 * Used to create the Plain Brush.
		 * 
		 * @return {@link Plain}
		 */
		@ClassType(Plain.class)
		GwtCreateResource<Brush> plain();

		/**
		 * Defines the Plain Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushPlain.js")
		interface Plain extends Brush {
		}

		/**
		 * Used to create the PowerShell Brush.
		 * 
		 * @return {@link PowerShell}
		 */
		@ClassType(PowerShell.class)
		GwtCreateResource<Brush> powerShell();

		/**
		 * Defines the PowerShell Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushPowerShell.js")
		interface PowerShell extends Brush {
		}

		/**
		 * Used to create the Python Brush.
		 * 
		 * @return {@link Python}
		 */
		@ClassType(Python.class)
		GwtCreateResource<Brush> python();

		/**
		 * Defines the Python Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushPython.js")
		interface Python extends Brush {
		}

		/**
		 * Used to create the RS Brush.
		 * 
		 * @return {@link RS}
		 */
		@ClassType(RS.class)
		GwtCreateResource<Brush> rs();

		/**
		 * Defines the RS Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushRS.js")
		interface RS extends Brush {
		}

		/**
		 * Used to create the Ruby Brush.
		 * 
		 * @return {@link Ruby}
		 */
		@ClassType(Ruby.class)
		GwtCreateResource<Brush> ruby();

		/**
		 * Defines the Ruby Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushRuby.js")
		interface Ruby extends Brush {
		}

		/**
		 * Used to create the Sass Brush.
		 * 
		 * @return {@link Sass}
		 */
		@ClassType(Sass.class)
		GwtCreateResource<Brush> sass();

		/**
		 * Defines the Sass Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushSass.js")
		interface Sass extends Brush {
		}

		/**
		 * Used to create the Scala Brush.
		 * 
		 * @return {@link Scala}
		 */
		@ClassType(Scala.class)
		GwtCreateResource<Brush> scala();

		/**
		 * Defines the Scala Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushScala.js")
		interface Scala extends Brush {
		}

		/**
		 * Used to create the Scheme Brush.
		 * 
		 * @return {@link Scheme}
		 */
		@ClassType(Scheme.class)
		GwtCreateResource<Brush> scheme();

		/**
		 * Defines the Scheme Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushScheme.js")
		interface Scheme extends Brush {
		}

		/**
		 * Used to create the Sql Brush.
		 * 
		 * @return {@link Sql}
		 */
		@ClassType(Sql.class)
		GwtCreateResource<Brush> sql();

		/**
		 * Defines the Sql Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushSql.js")
		interface Sql extends Brush {
		}

		/**
		 * Used to create the Vb Brush.
		 * 
		 * @return {@link Vb}
		 */
		@ClassType(Vb.class)
		GwtCreateResource<Brush> vb();

		/**
		 * Defines the Vb Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushVb.js")
		interface Vb extends Brush {
		}

		/**
		 * Used to create the Xml Brush.
		 * 
		 * @return {@link Xml}
		 */
		@ClassType(Xml.class)
		GwtCreateResource<Brush> xml();

		/**
		 * Defines the Xml Brush.
		 * 
		 * @author Xlorep DarkHelm
		 */
		@Brush.Source(Paths.BRUSHES + "shBrushXml.js")
		interface Xml extends Brush {
		}
	}

	/**
	 * Initialization class for the Resources interface.
	 * 
	 * @author Xlorep DarkHelm
	 * 
	 */
	static class Init implements Resources {

		/**
		 * Logging instance for the Init class.
		 */
		private static final Logger log = Logger
				.getLogger(Init.class.getName());
		/**
		 * Used in the {@code <style>} and {@code <script>} tags for the
		 * resources.
		 */
		private static final String ID_PREFIX = "SyntaxHighlighter:";
		/**
		 * Resources instance for the Init class.
		 */
		private static final Resources RES = GWT.create(Resources.class);
		/**
		 * Whether the resources are initialized or not.
		 */
		private static boolean initialized = false;

		/**
		 * Constructor that injects the {@link #coreStyle()}, {@link #GWTFix()},
		 * and {@link #theme()} CSS stylesheets, and the {@link #coreScript()}
		 * JavaScript script into the GWT app.
		 */
		Init() {
			if (!initialized) {
				log.finest("Injecting Standard SyntaxHighlighter CSS Resources.");
				coreStyle().ensureInjected();
				GWTFix().ensureInjected();

				log.finest("Injecting CSS Resource for theme \""
						+ theme().getClass().getName() + "\".");
				theme().create().ensureInjected();

				log.finest("Inserting Core SyntaxHighlighter JavaScript.");
				Document document = Document.get();
				HeadElement head = (HeadElement) document.getElementsByTagName(
						"head").getItem(0);
				ScriptElement element = document
						.createScriptElement(coreScript().getText());

				element.setId(ID_PREFIX + coreScript().getName());
				element.setType("text/javascript");

				head.appendChild(element);

				log.finest("SyntaxHighlighter Resources initialized.");
				initialized = true;
			}
		}

		@Override
		public GwtCreateResource<Theme> theme() {
			return RES.theme();
		}

		@Override
		public CssResource coreStyle() {
			return RES.coreStyle();
		}

		@Override
		public TextResource coreScript() {
			return RES.coreScript();
		}

		@Override
		public Brushes brushes() {
			return RES.brushes();
		}

		@Override
		public CssResource GWTFix() {
			return RES.GWTFix();
		}
	}

	/**
	 * Interface that contains the relative paths to the Core and Brush resource files.
	 * 
	 * @author Xlorep DarkHelm
	 *
	 */
	interface Paths {

		/**
		 * Relative path to the core resources.
		 */
		static final String CORE = "core/";
		
		/**
		 * Relative path to the Brush resources.
		 */
		static final String BRUSHES = "brushes/";
	}
}
