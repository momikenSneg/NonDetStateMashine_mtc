package machine;

import java.util.ArrayList;

public class Transition {
    private int from;
    private char symbol;
    private ArrayList<Integer> to = new ArrayList<>();

    public Transition(int from, char symbol) {
        this.from = from;
        this.symbol = symbol;
    }

    void addTo(Integer to){
        this.to.add(to);
    }

    public ArrayList<Integer> getEndStates() {
        return to;
    }

    public int getFrom() {
        return from;
    }

    public char getSymbol() {
        return symbol;
    }
}
