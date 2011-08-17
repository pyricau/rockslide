package info.piwai.cv.gwt.client.slider.highlighter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alexgorbatchev.syntaxhighlighter.client.Brush;
import com.alexgorbatchev.syntaxhighlighter.client.BrushHelper;
import com.alexgorbatchev.syntaxhighlighter.client.Highlighter;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * See http://code.google.com/p/gwt-syntaxhighlighter/issues/detail?id=11
 * 
 * This trick is used to use only one Highlighter for each brush at a time.
 */
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

    public void addHighlightedWidget(Brush brush, CodeHighlighter wrapper) {
        Highlighter highlighter = getHighlighter(brush);

        SimplePanel parent = (SimplePanel) highlighter.getParent();

        if (parent != null) {
            HighlighterClone clone = HighlighterClone.cloneHighlighter(highlighter);
            parent.clear();
            parent.setWidget(clone);
        }

        wrapper.prepareHighlighter(highlighter);
    }

    private Highlighter getHighlighter(Brush brush) {
        Highlighter highlighter = highlighters.get(brush);

        if (highlighter == null) {
            throw new IllegalArgumentException("This brush was not preloaded: " + brush.toString());
        }

        return highlighter;
    }

    public void loadHighlighters(final List<Brush> brushes, final HighlighterLoadHandler handler) {
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

    private void checkNotEmpty(final List<Brush> brushes) {
        if (brushes == null || brushes.size() == 0) {
            throw new IllegalArgumentException("brushes should not be null or empty");
        }
    }

    private void load(final List<Brush> brushes) {
        for (Brush brush : brushes) {
            highlighters.put(brush, new Highlighter(brush));
        }
    }

    private void scheduleCallback(final HighlighterLoadHandler handler, final List<Brush> brushes) {
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
