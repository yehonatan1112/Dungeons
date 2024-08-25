package dungeons.rooms;

import dungeons.Player;
import dungeons.Room;

public class TreasureRoom extends Room {
    private int goldAmount;

    public TreasureRoom() {
        this.goldAmount = random.nextInt(46) + 5;
    }

    @Override
    public void enter(Player player) {
        if (!isVisited) {
            player.addGold(goldAmount);
            System.out.println("You found " + goldAmount + " gold!");
            isVisited = true;
        } else {
            System.out.println("This room has already been visited.");
        }
    }
}
