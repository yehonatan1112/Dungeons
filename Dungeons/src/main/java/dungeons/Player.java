package dungeons;

import java.util.Random;

import static dungeons.utils.Constants.*;

public class Player {
    private int health = MAX_HP;
    private int gold = 0;
    private boolean isPoisoned = false;
    private boolean isCursed = false;
    private int poisonTurnsRemaining = 0;
    private int curseTurnsRemaining = 0;
    private double curseReductionFactor = 1.0;
    private int poisonDamagePerTurn = 0;
    private Random random = new Random();

    public void addGold(int amount) {
        gold += amount * curseReductionFactor;
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
        if (isCursed) {
            isPoisoned = false;
            poisonDamagePerTurn = 0;
        } else {
            int poisonType = random.nextInt(2);
            if (poisonType == 0) {
                poisonTurnsRemaining = 5;
                poisonDamagePerTurn = 2;
            } else {
                poisonTurnsRemaining = 4;
                poisonDamagePerTurn = 1;
            }
            isPoisoned = true;
        }
    }

    public void heal() {
        System.out.println("You have been healed!");
        health = Math.min(MAX_HP, health + HEALTH_INCREASE_POINTS);
    }

    public void curse() {
        System.out.println("You have been cursed!");
        if (isPoisoned) {
            isCursed = false;
            curseReductionFactor = 1.0;
        } else {
            double[] reductionFactors = {0.50, 0.40, 0.25};
            curseTurnsRemaining = 5;
            curseReductionFactor = reductionFactors[random.nextInt(reductionFactors.length)];
            isCursed = true;
        }
    }

    public void curePoison() {
        if(isPoisoned) {
            System.out.println("Poison cured!");
            isPoisoned = false;
            poisonDamagePerTurn = 0;
        } else
            System.out.println("You are not poised, No need to be cured!");
    }

    public void applyStatusEffects() {
        if (isPoisoned) {
            if (poisonTurnsRemaining > 0) {
                health -= poisonDamagePerTurn;
                poisonTurnsRemaining--;
                if (health <= 0) {
                    System.out.println("You have died from poison.");
                    System.exit(0);
                }
            }
            if (poisonTurnsRemaining <= 0) {
                isPoisoned = false;
                poisonDamagePerTurn = 0;
            }
        }

        if (isCursed) {
            if (curseTurnsRemaining > 0) {
                curseTurnsRemaining--;
                if (curseTurnsRemaining <= 0) {
                    isCursed = false;
                    curseReductionFactor = 1.0;
                }
            }
        }
    }

    public void printStatus() {
        String state = "healthy";
        if (isPoisoned) {
            state = "poisoned";
        } else if (isCursed) {
            state = "cursed";
        }
        System.out.println("Player Status:");
        System.out.println("Gold: " + gold);
        System.out.println("Health: " + health);
        System.out.println("State: " + state);
    }
}
