package dungeons.factory;

import dungeons.Room;
import dungeons.rooms.RitualRoom;
import dungeons.rooms.TrappedRoom;
import dungeons.rooms.TreasureRoom;
import java.util.Random;

public class RoomFactory {
    public static Room createRoom() {
        Random random = new Random();
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                return new TreasureRoom();
            case 1:
                return new TrappedRoom();
            case 2:
                return new RitualRoom();
            default:
                throw new IllegalStateException("Unexpected value (Can't create a room): " + type);
        }
    }
}
