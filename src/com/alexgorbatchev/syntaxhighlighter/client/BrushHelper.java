package com.alexgorbatchev.syntaxhighlighter.client;

public class BrushHelper {

    public static boolean isLoaded(Brush brush) {
        BrushImpl brushImpl = (BrushImpl) brush;
        return brushImpl.isLoaded();
    }

}
