package dungeons;

import dungeons.factory.RoomFactory;
import dungeons.output.ConsoleOutputHandler;
import dungeons.output.OutputHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Player player;
    private Room currentRoom;
    private static final Map<String, Integer> directionMap;

    static {
        directionMap = new HashMap<>();
        directionMap.put("left", 1);
        directionMap.put("right", 2);
        directionMap.put("forwards", 3);
        directionMap.put("backwards", 4);
    }

    public Game() {
        OutputHandler outputHandler = new ConsoleOutputHandler();
        this.player = new Player(outputHandler);
        this.currentRoom = RoomFactory.createRoom();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nIn which direction do you want to go? (left, right, forwards, backwards)");
            String choice = scanner.next().toLowerCase();
            Integer numericChoice = directionMap.get(choice);

            boolean isChoiceValid = numericChoice != null && numericChoice >= 1 && numericChoice <= 4;

            if (isChoiceValid) {
                if (currentRoom.getAdjacentRooms().isEmpty()) {
                    currentRoom.generateAdjacentRooms();
                }

                List<Room> adjacentRooms = currentRoom.getAdjacentRooms();

                if (numericChoice - 1 < adjacentRooms.size()) {
                    currentRoom = adjacentRooms.get(numericChoice - 1);
                    System.out.println("Welcome to " + currentRoom.getClass().getSimpleName());
                    currentRoom.enter(player);
                } else {
                    System.out.println("Invalid direction!");
                }
            } else {
                System.out.println("Invalid choice!");
            }

            if (player.getHealth() <= 0) {
                System.out.println("Game over!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
