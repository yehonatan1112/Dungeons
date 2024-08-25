package dungeons;

import static dungeons.utils.Constants.*;

public class Player {
    private int health = MAX_HP;
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
        health = Math.min(MAX_HP, health + HEALTH_INCREASE_POINTS);
    }

    public void curse() {
        System.out.println("You have been cursed!");
        isCursed = true;
    }

    public void curePoison() {
        if (isPoisoned) {
            System.out.println("Poison cured!");
            isPoisoned = false;
        } else {
            System.out.println("You are not poised! no need to cure");
        }
    }
}
