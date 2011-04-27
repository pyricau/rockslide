package com.excilys.formation.gwt.client.slider;

import java.util.HashMap;
import java.util.Map;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.BrushHelper;
import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;

public class HighlighterLoader {

    private static final HighlighterLoader INSTANCE = new HighlighterLoader();

    public static HighlighterLoader get() {
        return INSTANCE;
    }

    public interface HighlighterLoadHandler {
        void onHighlightersLoaded();
    }

    private final Map<Brush, Highlighter> highlighters = new HashMap<Brush, Highlighter>();

    private HighlighterLoader() {
    }

    public Highlighter getHighlighter(Brush brush) {
        Highlighter highlighter = highlighters.get(brush);

        if (highlighter == null) {
            throw new IllegalArgumentException("This brush was not preloaded: " + brush.toString());
        }

        return highlighter;
    }

    public void loadHighlighters(final HighlighterLoadHandler handler, final Brush... brushes) {

        checkAlreadyLoaded();
        checkNotEmpty(brushes);
        load(brushes);
        scheduleCallback(handler, brushes);
    }

    private void checkAlreadyLoaded() {
        if (!highlighters.isEmpty()) {
            throw new IllegalStateException("Highlighters have already been loaded");
        }
    }

    private void checkNotEmpty(final Brush... brushes) {
        if (brushes == null || brushes.length == 0) {
            throw new IllegalArgumentException("brushes should not be null or empty");
        }
    }

    private void load(final Brush... brushes) {
        for (Brush brush : brushes) {
            highlighters.put(brush, new Highlighter(brush));
        }
    }

    private void scheduleCallback(final HighlighterLoadHandler handler, final Brush... brushes) {
        Scheduler.get().scheduleFixedDelay(new RepeatingCommand() {

            @Override
            public boolean execute() {
                for (Brush brush : brushes) {
                    if (!BrushHelper.isLoaded(brush)) {
                        return true;
                    }
                }
                handler.onHighlightersLoaded();
                return false;
            }
        }, 200);
    }
}
