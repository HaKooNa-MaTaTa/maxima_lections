package proxy;

public class Main {

    public static void main(String[] args) {
        InputOutput inputOutput = new InputOutputImpl("text.txt");
        inputOutput = LoggerWrapper.withLogger(inputOutput);
        inputOutput.output("Hi!");
        inputOutput.output("How are you?");
        System.out.println(inputOutput.input());
    }
}
