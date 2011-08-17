package info.piwai.rockslide.client.slides;

public class ClassHelper {

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

}
