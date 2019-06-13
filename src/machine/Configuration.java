package machine;

public class Configuration {
    private int curState;
    private int curIndex;

    public Configuration(int currentState, int currentIndex) {
        this.curState = currentState;
        this.curIndex = currentIndex;
    }

    public int getCurState() {
        return curState;
    }

    public int getCurIndex() {
        return curIndex;
    }
}
