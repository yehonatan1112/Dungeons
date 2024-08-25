package dungeons;


public class Player {
    private int health = 100;
    private int gold = 0;
    private boolean isPoisoned = false;
    private boolean isCursed = false;

    public void addGold(int amount) {
        gold += amount;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("You have died.");
            System.exit(0);
        }
    }

    public void poison() {
        System.out.println("You have been poisoned!");
        isPoisoned = true;
    }

    public void heal() {
        System.out.println("You have been healed!");
        health = Math.min(100, health + 10);
    }

    public void curse() {
        System.out.println("You have been cursed!");
        isCursed = true;
    }

    public void curePoison() {
        System.out.println("Poison cured!");
        isPoisoned = false;
    }

    public void update(Room room) {
        room.enter(this);
    }
}
