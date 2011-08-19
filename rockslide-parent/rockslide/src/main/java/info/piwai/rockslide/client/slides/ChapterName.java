package info.piwai.rockslide.client.slides;

public class ChapterName {
    
    private final String historyName;

    private final String readableName;
    
    public ChapterName(String historyName, String readableName) {
        this.historyName = historyName;
        this.readableName = readableName;
    }

    public String getHistoryName() {
        return historyName;
    }
    
    public String getReadableName() {
        return readableName;
    }

}
