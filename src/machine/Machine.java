package machine;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Machine {
    private ArrayList<Integer> finStates = new ArrayList<>();
    private ArrayList<Transition> transitions = new ArrayList<>();

    public Machine(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        String[] split = sc.nextLine().split(" ");
        for (String s : split) {
            finStates.add(Integer.valueOf(s));
        }
        while (sc.hasNext()) {
            split = sc.nextLine().split(" ");
            int from = Integer.parseInt(split[0]);
            char symbol = split[1].charAt(0);
            int to = Integer.parseInt(split[2]);
            Transition curTransition = new Transition(from, symbol);
            boolean exist = false;
            for (Transition transition : transitions){
                if (transition.getFrom() == curTransition.getFrom() && transition.getSymbol() == curTransition.getSymbol()){
                    exist = true;
                    transition.addTo(to);
                }
            }
            if (!exist) {
                curTransition.addTo(to);
                transitions.add(curTransition);
            }
        }
    }

    public boolean recognize(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        String recString = sc.nextLine();
        int i = 0;
        int len = recString.length();

        Stack<Configuration> stack = new Stack<>();
        stack.push(new Configuration(0, 0));
        while (!stack.isEmpty()) {
            Configuration configuration = stack.pop();
            char c = recString.charAt(i);
            i++;
            for (Transition transition: transitions) {
                if (transition.getFrom() == (configuration.getCurState()) && transition.getSymbol() == c) {
                    ArrayList<Integer> endStates = transition.getEndStates();
                    for (Integer state: endStates){
                        stack.push( new Configuration(state, configuration.getCurIndex() + 1));
                    }
                }
            }
            if (i == len){
                for (Integer endState : finStates) {
                    if (endState == configuration.getCurState())
                        return true;
                }
            }
        }
        return false;
    }
}
