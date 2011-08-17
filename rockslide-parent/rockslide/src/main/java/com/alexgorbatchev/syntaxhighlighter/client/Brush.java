/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexgorbatchev.syntaxhighlighter.client;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * <p>Interface that should be extended to add new Brushes to the system. New
 * brushes are simply annotated with the correct path to the JavaScript source
 * with the {@link Source} annotation. For example:</p>
 *
 * <blockquote><pre>
 * {@literal @Brush.Source("shBrushPlain.js")}
 * interface Plain extends Brush { }
 * </pre></blockquote>
 *
 * <p>Then, simply pass the new Brush to {@code GWT.create()}:
 *
 * <blockquote>
 * {@code Plain plainBrush = GWT.create(Plain.class);}
 * </blockquote>
 *
 * <p>Or, for a UiBinder XML file:</p>
 *
 * <blockquote><pre>
 * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
 *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
 *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
 *              >
 *     {@literal <ui:with field="plain" type="path.to.your.brush.Plain"/>}
 *
 *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{plain}"/>}
 * {@literal </ui:UiBinder>}
 * </pre></blockquote>
 *
 * @author Xlorep DarkHelm
 * @see <a target="_blank" href="http://code.google.com/webtoolkit/doc/latest/DevGuideUiBinder.html">GWT: Declarative Layout with UiBinder</a>
 */
public interface Brush {

    /**
     * Annotation used to define new Brushes.
     *
     * @author Xlorep DarkHelm
     */
    @Target({ElementType.TYPE})
    public static @interface Source {

        /**
         * Filename for the javascript file to use with this Brush. The
         * path is relative to the path of the Brush that is annotated with this.
         *
         * @return the filename for the javascript file.
         */
        public String value();
    }

    /**
     * <p>Class containing access to the standard set of brushes, and a number
     * of custom brushes available to the SyntaxHighlighter. This is a
     * convenient way to get all of these brushes, and they can even be used
     * within the UiBinder using the {@code <ui:with>} directive, like this:</p>
     *
     * <blockquote><pre>
     * {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
     * </pre></blockquote>
     *
     * <p><b>Note:</b> This class is is not needed for user-defined brushes. This
     * simply allows for the standard brushes to be available to be used. For
     * user-defined brushes, simply extend the {@link Brush} interface and use
     * {@code GWT.create()} to instantiate the Brush.</p>
     *
     * @author Xlorep DarkHelm
     * @see <a target="_blank" href="http://code.google.com/webtoolkit/doc/latest/DevGuideUiBinder.html">GWT: Declarative Layout with UiBinder</a>
     */
    public static final class Brushes {

        private static final Resources.Brushes BRUSHES = Resources.INSTANCE.brushes();

        /**
         * Gets the Progress/ABL/OpenEdge Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.ABL}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Progress/ABL/OpenEdge Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/forums/viewtopic.php?f=2&t=11">SyntaxHighlighter Forums: Progress / OpenEdge / ABL</a>
         * @see <a target="_blank" href="http://en.wikipedia.org/wiki/OpenEdge_Advanced_Business_Language">Wikipedia: OpenEdge Advanced Business Language</a>
         */
        public final static Brush ABL() {
            return BRUSHES.abl().create();
        }

        /**
         * Gets the AppleScript Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.APPLESCRIPT}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The AppleScript Brush
         * @see <a target="_blank" href="http://developer.apple.com/applescript/">Official AppleScript site</a>
         */
        public final static Brush APPLESCRIPT() {
            return BRUSHES.appleScript().create();
        }

        /**
         * Gets the AS3 Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.AS3}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The ActionScript3 Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/actionscript3.html">SyntaxHighlighter Manual: ActionScript3 Brush</a>
         */
        public final static Brush AS3() {
            return BRUSHES.as3().create();
        }

        /**
         * Gets the AutoIt Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.AU3}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The AutoIt Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/forums/viewtopic.php?f=2&t=9">SyntaxHighlighter Forums: Custom brush: AutoIt</a>
         * @see <a target="_blank" href="http://www.autoitscript.com/autoit3/index.shtml">Official AutoIt site</a>
         */
        public final static Brush AU3() {
            return BRUSHES.au3().create();
        }

        /**
         * Gets the Bash/shell Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.BASH}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Bash/shell Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/bash.html">SyntaxHighlighter Manual: Bash/shell Brush</a>
         */
        public final static Brush BASH() {
            return BRUSHES.bash().create();
        }

        /**
         * Gets the C# Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.CSHARP}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The C# Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/csharp.html">SyntaxHighlighter Manual: C# Brush</a>
         */
        public final static Brush CSHARP() {
            return BRUSHES.cSharp().create();
        }

        /**
         * Gets the ColdFusion Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.COLDFUSION}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The ColdFusion Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/coldfusion.html">SyntaxHighlighter Manual: ColdFusion Brush</a>
         */
        public final static Brush COLDFUSION() {
            return BRUSHES.coldFusion().create();
        }

        /**
         * Gets the C++ Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.CPP}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The C++ Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/cpp.html">SyntaxHighlighter Manual: C++ Brush</a>
         */
        public final static Brush CPP() {
            return BRUSHES.cpp().create();
        }

        /**
         * Gets the CSS Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.CSS}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The CSS Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/css.html">SyntaxHighlighter Manual: CSS Brush</a>
         */
        public final static Brush CSS() {
            return BRUSHES.css().create();
        }

        /**
         * Gets the Delphi Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.DELPHI}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Delphi Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/delphi.html">SyntaxHighlighter Manual: Delphi Brush</a>
         */
        public final static Brush DELPHI() {
            return BRUSHES.delphi().create();
        }

        /**
         * Gets the Diff Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.DIFF}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Diff Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/diff.html">SyntaxHighlighter Manual: Diff Brush</a>
         */
        public final static Brush DIFF() {
            return BRUSHES.diff().create();
        }

        /**
         * Gets the Erlang Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.ERLANG}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Erlang Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/erlang.html">SyntaxHighlighter Manual: Erlang Brush</a>
         */
        public final static Brush ERLANG() {
            return BRUSHES.erlang().create();
        }

        /**
         * Gets the Groovy Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.GROOVY}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Groovy Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/groovy.html">SyntaxHighlighter Manual: Groovy Brush</a>
         */
        public final static Brush GROOVY() {
            return BRUSHES.groovy().create();
        }

        /**
         * Gets the JavaScript Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.JSCRIPT}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The JavaScript Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/javascript.html">SyntaxHighlighter Manual: JavaScript Brush</a>
         */
        public final static Brush JSCRIPT() {
            return BRUSHES.jScript().create();
        }

        /**
         * Gets the Java Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.JAVA}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Java Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/java.html">SyntaxHighlighter Manual: Java Brush</a>
         */
        public final static Brush JAVA() {
            return BRUSHES.java().create();
        }

        /**
         * Gets the JavaFX Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.JAVAFX}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The JavaFX Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/javafx.html">SyntaxHighlighter Manual: JavaFX Brush</a>
         */
        public final static Brush JAVAFX() {
            return BRUSHES.javaFX().create();
        }

        /**
         * Gets the Lisp Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.LISP}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Lisp Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/forums/viewtopic.php?f=2&t=45">SyntaxHighlighter Forums: Brush: Lisp</a>
         * @see <a target="_blank" href="http://en.wikipedia.org/wiki/Lisp_(programming_language)">Wikipedia: Lisp (programming language)</a>
         */
        public final static Brush LISP() {
            return BRUSHES.lisp().create();
        }

        /**
         * Gets the Perl Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.PERL}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Perl Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/perl.html">SyntaxHighlighter Manual: Perl Brush</a>
         */
        public final static Brush PERL() {
            return BRUSHES.perl().create();
        }

        /**
         * Gets the PHP Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.PHP}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The PHP Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/php.html">SyntaxHighlighter Manual: PHP Brush</a>
         */
        public final static Brush PHP() {
            return BRUSHES.php().create();
        }

        /**
         * Gets the Plain Text Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.PLAIN}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Plain Text Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/plain.html">SyntaxHighlighter Manual: Plain Text Brush</a>
         */
        public final static Brush PLAIN() {
            return BRUSHES.plain().create();
        }

        /**
         * Gets the PowerShell Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.POWERSHELL}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The PowerShell Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/powershell.html">SyntaxHighlighter Manual: PowerShell Brush</a>
         */
        public final static Brush POWERSHELL() {
            return BRUSHES.powerShell().create();
        }

        /**
         * Gets the Python Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.PYTHON}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Python Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/python.html">SyntaxHighlighter Manual: Python Brush</a>
         */
        public final static Brush PYTHON() {
            return BRUSHES.python().create();
        }

        /**
         * Gets the R/S+ Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.RS}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The R/S+ Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/forums/viewtopic.php?f=2&t=60">SyntaxHighligher Forums: Custom brush: R/S+</a>
         * @see <a target="_blank" href="http://en.wikipedia.org/wiki/R_programming_language">Wikipedia: R (programming language)</a>
         * @see <a target="_blank" href="http://en.wikipedia.org/wiki/S_programming_language">Wikipedia: S (programming language)</a>
         */
        public final static Brush RS() {
            return BRUSHES.ruby().create();
        }

        /**
         * Gets the Ruby Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.RUBY}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Ruby Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/ruby.html">SyntaxHighlighter Manual: Ruby Brush</a>
         */
        public final static Brush RUBY() {
            return BRUSHES.ruby().create();
        }

        /**
         * Gets the SASS/SCSS Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.SASS}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The SASS/SCSS Brush
         * @see <a target="_blank" href="http://sass-lang.com/">Official SASS/SCSS site</a>
         */
        public final static Brush SASS() {
            return BRUSHES.sass().create();
        }

        /**
         * Gets the Scala Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.SCALA}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Scala Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/scala.html">SyntaxHighlighter Manual: Scala Brush</a>
         */
        public final static Brush SCALA() {
            return BRUSHES.scala().create();
        }

        /**
         * Gets the Scheme/PLT Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.SCHEME}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Scheme/PLT Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/forums/viewtopic.php?f=2&t=49">SyntaxHighlighter Forums: Custom brush: Scheme/PLT</a>
         * @see <a target="_blank" href="http://en.wikipedia.org/wiki/Scheme_(programming_language)">Wikipedia: Scheme (programming language)</a>
         */
        public final static Brush SCHEME() {
            return BRUSHES.scheme().create();
        }

        /**
         * Gets the SQL Brush.
         * For example:
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.SQL}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The SQL Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/sql.html">SyntaxHighlighter Manual: SQL Brush</a>
         */
        public final static Brush SQL() {
            return BRUSHES.sql().create();
        }

        /**
         * Gets the Visual Basic Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.VB}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The Visual Basic Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/vb.html">SyntaxHighlighter Manual: Visual Basic Brush</a>
         */
        public final static Brush VB() {
            return BRUSHES.vb().create();
        }

        /**
         * Gets the XML Brush.
         * <blockquote><pre>
         * {@literal <ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'}
         *              xmlns:gwt='urn:import:com.google.gwt.user.client.ui'
         *              xmlns:syntax='urn:import:com.alexgorbatchev.syntaxhighlighter.client'
         *              >
         *     {@literal <ui:with field="brushes" type="com.alexgorbatchev.syntaxhighlighter.client.Brush.Brushes"/>}
         *
         *     {@literal <syntax:Highlighter ui:field="sourceCode" brush="{brushes.XML}"/>}
         * {@literal </ui:UiBinder>}
         * </pre></blockquote>
         * @return The XML Brush
         * @see <a target="_blank" href="http://alexgorbatchev.com/SyntaxHighlighter/manual/brushes/xml.html">SyntaxHighlighter Manual: XML Brush</a>
         */
        public final static Brush XML() {
            return BRUSHES.xml().create();
        }
    }
}
