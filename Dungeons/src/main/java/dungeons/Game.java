package dungeons;

import dungeons.factory.RoomFactory;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private Room currentRoom;

    public Game() {
        this.player = new Player();
        this.currentRoom = RoomFactory.createRoom();
        this.currentRoom.generateAdjacentRooms();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("You are in front of the room. What do you want to do?");
            System.out.println("1. Enter the room");
            System.out.println("2. Move to an adjacent room (type 2-4)");

            int choice = scanner.nextInt();
            if (choice == 1) {
                player.update(currentRoom);
            } else if (choice >= 2 && choice <= 4) {
                List<Room> adjacentRooms = currentRoom.getAdjacentRooms();
                if (choice - 2 < adjacentRooms.size()) {
                    currentRoom = adjacentRooms.get(choice - 2);
                    currentRoom.generateAdjacentRooms();
                    player.update(currentRoom);
                } else {
                    System.out.println("Invalid direction!");
                }
            } else {
                System.out.println("Invalid choice!");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
