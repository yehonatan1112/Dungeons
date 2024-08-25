package dungeons.output;

public class ConsoleOutputHandler implements OutputHandler {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
