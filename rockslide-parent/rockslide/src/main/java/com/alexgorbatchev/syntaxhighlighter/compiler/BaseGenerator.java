package com.alexgorbatchev.syntaxhighlighter.compiler;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.ConfigurationProperty;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.PropertyOracle;
import com.google.gwt.core.ext.SelectionProperty;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;

import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JPackage;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;

import com.google.gwt.dev.resource.ResourceOracle;

import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

import java.io.PrintWriter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Abstract base class for both the {@link BrushGenerator} and
 * {@link ThemeGenerator} classes.
 * 
 * @author Xlorep DarkHelm
 * 
 */
abstract class BaseGenerator extends Generator {

	/**
	 * The line separator property for the system.
	 */
	protected static final String NL = System.getProperty("line.separator");
	/**
	 * The file separator.
	 */
	protected static final String FSEP = "/";
	/**
	 * The parent directory for the file path.
	 */
	protected static final String FPAR = "..";
	/**
	 * The type to be generated from.
	 */
	private JClassType type;
	/**
	 * The superclass type to be generated with.
	 */
	private JClassType superType;
	/**
	 * The {@link TreeLogger} instance for the GWT Compiler.
	 */
	private TreeLogger log;
	/**
	 * The {@link GeneratorContext}
	 */
	private GeneratorContext ctx;
	/**
	 * The {@link PropertyOracle} from the GeneratorContext.
	 */
	private PropertyOracle propOracle;
	/**
	 * The {@link TypeOracle} from the GeneratorContext.
	 */
	private TypeOracle typeOracle;
	/**
	 * The {@link ResourceOracle} from the GeneratorContext.
	 */
	private ResourceOracle resOracle;

	/**
	 * Core method that is called to start a generator process.
	 */
	@Override
	public final String generate(TreeLogger logger, GeneratorContext context,
			String typeName) throws UnableToCompleteException {
		typeOracle = context.getTypeOracle();
		propOracle = context.getPropertyOracle();
		resOracle = context.getResourcesOracle();

		type = findType(typeName);

		try {
			superType = getType(getSuper());
		} catch (NotFoundException ex) {
			log(TreeLogger.ERROR, null, ex);

			throw new UnableToCompleteException();
		}

		log = logger;
		ctx = context;

		SourceWriter writer = getSourceWriter();
		if (writer != null) {
			generate(writer);

			writer.commit(log);

			log(TreeLogger.INFO, "Generated class: " + getQualifiedName());
		}

		log(TreeLogger.INFO,
				"Replacing class \"" + type.getQualifiedSourceName()
						+ "\" with \"" + getQualifiedName() + "\".");

		return getQualifiedName();
	}

	/**
	 * Generates the Java code to be used.
	 * 
	 * @param writer
	 *            The {@link SourceWriter} that is used to write the Java code
	 *            with.
	 * 
	 * @throws UnableToCompleteException
	 */
	protected abstract void generate(SourceWriter writer)
			throws UnableToCompleteException;

	/**
	 * @return the name for the Java class that is generated.
	 * 
	 * @throws UnableToCompleteException
	 */
	protected abstract String getName() throws UnableToCompleteException;

	/**
	 * 
	 * @return the fully-qualified name of the superclass for the Java class
	 *         that is generated.
	 */
	protected abstract String getSuper();

	/**
	 * 
	 * @return an array containing the list of imports for the Java class.
	 */
	protected abstract String[] getImports();

	/**
	 * 
	 * @return the package name for the generated Java class.
	 */
	protected final String getPackageName() {
		return superType.getPackage().getName();
	}

	/**
	 * 
	 * @return the qualified name for {@link #superType}.
	 */
	protected final String getSuperName() {
		return superType.getName();
	}

	/**
	 * 
	 * @param propertyName
	 *            the name of the {@link SelectionProperty} to get.
	 * 
	 * @return the SelectionProperty that was retrieved.
	 * 
	 * @throws BadPropertyValueException
	 */
	protected final SelectionProperty getSelectionProperty(String propertyName)
			throws BadPropertyValueException {
		return propOracle.getSelectionProperty(log, propertyName);
	}

	/**
	 * 
	 * @param propertyName
	 *            the name of the {@link ConfigurationProperty} to get.
	 * 
	 * @return the ConfigurationProperty that was retrieved.
	 * 
	 * @throws BadPropertyValueException
	 */
	protected final ConfigurationProperty getConfigurationProperty(
			String propertyName) throws BadPropertyValueException {
		return propOracle.getConfigurationProperty(propertyName);
	}

	/**
	 * 
	 * @param pkgName
	 *            the package name to look for.
	 * 
	 * @param typeName
	 *            the type name to look for.
	 * 
	 * @return the {@link JClassType} for the given package and type names.
	 */
	protected final JClassType findType(String pkgName, String typeName) {
		return typeOracle.findType(pkgName, typeName);
	}

	/**
	 * 
	 * @param name
	 *            the type name to look for.
	 * 
	 * @return the {@link JClassType} for the given type name.
	 */
	protected final JClassType findType(String name) {
		return typeOracle.findType(name);
	}

	/**
	 * 
	 * @return Array containing all {@link JClassType JClassTypes} that are
	 *         defined in the {@link #typeOracle}.
	 */
	protected final JClassType[] getTypes() {
		return typeOracle.getTypes();
	}

	/**
	 * 
	 * @param pkgName
	 *            the package name to get.
	 * 
	 * @param topLevelTypeSimpleName
	 *            the simple name for the top level type to get.
	 * 
	 * @return the {@link JClassType} that was found.
	 * 
	 * @throws NotFoundException
	 */
	protected final JClassType getType(String pkgName,
			String topLevelTypeSimpleName) throws NotFoundException {
		return typeOracle.getType(pkgName, topLevelTypeSimpleName);
	}

	/**
	 * 
	 * @param name
	 *            the name of the type to get.
	 * 
	 * @return the {@link JClassType} that was found.
	 * 
	 * @throws NotFoundException
	 */
	protected final JClassType getType(String name) throws NotFoundException {
		return typeOracle.getType(name);
	}

	/**
	 * 
	 * @return Array containing all {@link JPackage JPackages} from the
	 *         {@link #typeOracle}.
	 */
	protected final JPackage[] getPackages() {
		return typeOracle.getPackages();
	}

	/**
	 * 
	 * @param pkgName
	 *            package to get.
	 * 
	 * @return The {@link JPackage} that was found.
	 * 
	 * @throws NotFoundException
	 */
	protected final JPackage getPackage(String pkgName)
			throws NotFoundException {
		return typeOracle.getPackage(pkgName);
	}

	/**
	 * 
	 * @param pkgName
	 *            package to find.
	 * 
	 * @return The {@link JPackage} that was found.
	 */
	protected final JPackage findPackage(String pkgName) {
		return typeOracle.findPackage(pkgName);
	}

	/**
	 * 
	 * @param type
	 *            The {@link TreeLogger.Type} to log.
	 * 
	 * @param msg
	 *            The message to log.
	 * 
	 * @param caught
	 *            The Throwable that was caught.
	 */
	protected final void log(Type type, String msg, Throwable caught) {
		log.log(type, msg, caught);
	}

	/**
	 * 
	 * @param type
	 *            The {@link TreeLogger.Type} to log.
	 * 
	 * @param msg
	 *            The message to log.
	 */
	protected final void log(Type type, String msg) {
		log.log(type, msg);
	}

	/**
	 * 
	 * @param type
	 *            The {@link TreeLogger.Type} to test.
	 * 
	 * @return true if loggable, false if not.
	 */
	protected final boolean isLoggable(Type type) {
		return log.isLoggable(type);
	}

	/**
	 * 
	 * @return {@link #type}
	 */
	protected final JClassType getType() {
		return type;
	}

	/**
	 * 
	 * @return {@link ResourceOracle#getPathNames()}
	 */
	protected final Set<String> getPathNames() {
		return resOracle.getPathNames();
	}

	/**
	 * 
	 * @return The fully-qualified path name for the generated Java class.
	 * 
	 * @throws UnableToCompleteException
	 */
	protected final String getQualifiedName() throws UnableToCompleteException {
		return String.format("%s.%s", getPackageName(), getName());
	}

	/**
	 * 
	 * @param resource
	 *            the resource to find the path for.
	 * 
	 * @return the full path from the {@link #resOracle} for the given resource.
	 */
	protected final String getPath(String resource) {
		String resourcePath = null;
		for (String path : resOracle.getPathNames()) {
			if (path.contains(resource)) {
				path = path.substring(0, path.indexOf(resource));
				path = path.replace("/", FSEP);
				resourcePath = path;
				break;
			}
		}
		return resourcePath;
	}

	/**
	 * 
	 * @param packageName
	 *            package name to convert into a path.
	 * 
	 * @return the file path version of the package name.
	 */
	private String toPath(String packageName) {
		return packageName.replace(".", FSEP) + FSEP;
	}

	/**
	 * 
	 * @param path
	 *            The path to split.
	 * 
	 * @return {@literal Queue<String>} containing each folder in order defined
	 *         in the given path.
	 */
	private Queue<String> splitPath(String path) {
		return new LinkedList<String>(Arrays.asList(path.split(FSEP)));
	}

	/**
	 * 
	 * @param resource
	 *            The resource to build the path for.
	 * 
	 * @return The full path for the given resource relative to the new Java
	 *         class that was generated.
	 */
	protected final String buildPath(String resource) {
		log(TreeLogger.INFO, "Building path to resource: " + resource);
		return buildPath(splitPath(getPath(resource)), 0,
				splitPath(toPath(getPackageName())), 0) + resource;
	}

	/**
	 * Recursive method that constructs the complete path to a given resource
	 * relative to the new Java class that was generated.
	 * 
	 * @param origPath
	 *            Original path to the resource based on the original type
	 *            passed to the Generator.
	 * @param origCnt
	 *            number of folders that have been traversed from the original
	 *            path.
	 * @param newPath
	 *            Path to the new Java class that was generated.
	 * @param newCnt
	 *            number of folders that have been traversed from the new path.
	 * 
	 * @return The combined string containing the new path to the resource.
	 */
	private String buildPath(Queue<String> origPath, int origCnt,
			Queue<String> newPath, int newCnt) {
		if (origPath.isEmpty() && newPath.isEmpty()) {
			return "";
		} else if (origCnt == newCnt && origPath.peek().equals(newPath.peek())) {
			origPath.poll();
			newPath.poll();
			return buildPath(origPath, ++origCnt, newPath, ++newCnt);
		} else if (!newPath.isEmpty()) {
			if (newPath.poll().trim().length() > 0) {
				return FPAR + FSEP
						+ buildPath(origPath, origCnt, newPath, ++newCnt);
			} else {
				return buildPath(origPath, origCnt, newPath, ++newCnt);
			}
		} else {
			StringBuilder builder = new StringBuilder();
			for (String folder : origPath) {
				if (folder.trim().length() > 0) {
					builder.append(folder + FSEP);
				}
			}
			return builder.toString();
		}
	}

	/**
	 * 
	 * @return The {@link SourceWriter} to use to generate the Java code with.
	 * 
	 * @throws UnableToCompleteException
	 */
	protected final SourceWriter getSourceWriter()
			throws UnableToCompleteException {
		ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(
				getPackageName(), getName());
		composer.setSuperclass(getSuperName());

		if (type.isInterface() != null) {
			composer.addImplementedInterface(type.getQualifiedSourceName());
		}

		for (String importPath : getImports()) {
			composer.addImport(importPath);
		}

		PrintWriter printWriter = ctx.tryCreate(log, getPackageName(),
				getName());

		if (printWriter == null) {
			log(TreeLogger.INFO, "Class \"" + getName()
					+ "\" already generated.");
			return null;
		} else {
			SourceWriter sw = composer.createSourceWriter(ctx, printWriter);
			return sw;
		}
	}
}
