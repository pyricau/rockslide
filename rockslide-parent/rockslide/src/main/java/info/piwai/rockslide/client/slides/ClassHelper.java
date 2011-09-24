/**
 * Copyright (C) 2011 Pierre-Yves Ricau (py.ricau at gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed To in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package info.piwai.rockslide.client.slides;

public class ClassHelper {
	
	private static final String IMPL_SUFFIX = "Impl";

    public static String getSimpleName(Object instance) {
        return getSimpleName(instance.getClass());
    }

    public static String getSimpleName(Class<?> clazz) {
        return getSimpleName(clazz.getName());
    }

    /**
     * GWT doest support Class.getSimpleName() yet.
     * 
     * See issue
     * http://code.google.com/p/google-web-toolkit/issues/detail?id=3404
     */
    public static String getSimpleName(String fullyQualifiedName) {
        int lastDotIndex = fullyQualifiedName.lastIndexOf(".");

        if (lastDotIndex != -1) {
            return fullyQualifiedName.substring(lastDotIndex + 1);
        } else {
            return fullyQualifiedName;
        }
    }
    
	public static String getUiBinderName(Object uiBinder) {
		String uiBinderClassSimpleName = ClassHelper.getSimpleName(uiBinder.getClass());

		int separatorIndex = uiBinderClassSimpleName.indexOf('_');

		String nameWithoutChapterClassName;
		if (separatorIndex != -1) {
			nameWithoutChapterClassName = uiBinderClassSimpleName.substring(separatorIndex);
		} else {
			nameWithoutChapterClassName = uiBinderClassSimpleName;
		}
		
		if (nameWithoutChapterClassName.startsWith("_")) {
			nameWithoutChapterClassName = nameWithoutChapterClassName.substring(1);
		}

		if (nameWithoutChapterClassName.endsWith(IMPL_SUFFIX)) {
			int finalNameLength = nameWithoutChapterClassName.length() - IMPL_SUFFIX.length();
			return nameWithoutChapterClassName.substring(0, finalNameLength);
		} else {
			return nameWithoutChapterClassName;
		}

	}

}
