package dungeons.rooms;

import dungeons.Player;
import dungeons.Room;
import static dungeons.utils.Constants.*;

public class TreasureRoom extends Room {
    private int goldAmount;

    public TreasureRoom() {
        this.goldAmount = random.nextInt(MAX_OF_GOLD - 4) + MIN_OF_GOLD;
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
