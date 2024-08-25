package dungeons.rooms;

import dungeons.Player;
import dungeons.Room;
import dungeons.utils.RitualType;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public class RitualRoom extends Room {
    private RitualType ritualType;
    private static final Map<RitualType, Consumer<Player>> RITUAL_ACTIONS;

    static {
        RITUAL_ACTIONS = new EnumMap<>(RitualType.class);
        RITUAL_ACTIONS.put(RitualType.POISON, Player::poison);
        RITUAL_ACTIONS.put(RitualType.HEAL, Player::heal);
        RITUAL_ACTIONS.put(RitualType.CURSE, Player::curse);
        RITUAL_ACTIONS.put(RitualType.ANTIDOTE, Player::curePoison);
    }

    public RitualRoom() {
        RitualType[] values = RitualType.values();
        this.ritualType = values[random.nextInt(values.length)];
    }

    @Override
    public void enter(Player player) {
        if (!isVisited) {
            RITUAL_ACTIONS.get(ritualType).accept(player);
            isVisited = true;
        } else {
            System.out.println("This room has already been visited.");
        }
    }
}
