package machine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Machine machine = new Machine(args[0]);
        if (machine.recognize(args[1])){
            System.out.println("Recognized");
        } else {
            System.out.println("Not recognized");
        }
    }
}
