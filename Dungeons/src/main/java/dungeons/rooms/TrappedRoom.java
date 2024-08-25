package dungeons.rooms;

import dungeons.Player;
import dungeons.Room;

public class TrappedRoom extends Room {
    private boolean isTrapTriggered = false;
    private int trapDamage;

    public TrappedRoom() {
        this.trapDamage = random.nextInt(5) + 1;
    }

    @Override
    public void enter(Player player) {
        if (!isVisited) {
            if (random.nextBoolean()) {
                player.takeDamage(trapDamage);
                System.out.println("You triggered a trap and took " + trapDamage + " damage!");
            } else {
                System.out.println("No trap in this room, You Safe!");
            }
            isVisited = true;
        } else {
            System.out.println("This room has already been visited.");
        }
    }
}
