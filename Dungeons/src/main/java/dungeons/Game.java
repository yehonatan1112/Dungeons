package dungeons;

import dungeons.factory.RoomFactory;

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
        directionMap.put("status", 5);
    }

    public Game() {
        this.player = new Player();
        this.currentRoom = RoomFactory.createRoom();
        this.currentRoom.generateAdjacentRooms();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nIn which direction you want to go? (left, right, forwards, backwards)");
            String choice = scanner.next().toLowerCase();
            if(directionMap.containsKey(choice)) {
                Integer numericChoice = directionMap.get(choice);
                if (numericChoice >= 1 && numericChoice <= 4) {
                    List<Room> adjacentRooms = currentRoom.getAdjacentRooms();

                    if (numericChoice - 1 < adjacentRooms.size()) {
                        currentRoom = adjacentRooms.get(numericChoice - 1);
                        System.out.println("Welcome to " + currentRoom.getClass().getSimpleName());
                        currentRoom.generateAdjacentRooms();
                        currentRoom.enter(player);
                    } else {
                        System.out.println("Invalid direction! There is no room at this direction");
                    }
                } else if (numericChoice == 5) {
                    player.applyStatusEffects();
                    player.printStatus();
                } else {
                    System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
