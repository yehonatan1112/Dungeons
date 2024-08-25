package dungeons;

import dungeons.factory.RoomFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static dungeons.utils.Constants.*;

public abstract class Room {
    protected List<Room> adjacentRooms = new ArrayList<>();
    protected boolean isVisited = false;
    protected Random random = new Random();

    public abstract void enter(Player player);

    public void generateAdjacentRooms() {
        int numAdjacent = random.nextInt(MAX_ADJ_ROOMS + 1) + 1;
        for (int i = 0; i < numAdjacent; i++) {
            Room newRoom = RoomFactory.createRoom();
            if (!adjacentRooms.contains(newRoom)) {
                adjacentRooms.add(newRoom);
            }
        }
    }

    public List<Room> getAdjacentRooms() {
        return adjacentRooms;
    }
}

