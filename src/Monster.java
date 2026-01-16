public class Monster {
    private int health;
    private int attack;

    public Monster() {
        health = 2;
        attack = 1;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealth(int num) {
        health = num;
    }

    public void attack(Adventurer adventurer) {
        adventurer.reduceHealth(1);
    }

    public void round(boolean attackResult) {
        boolean attackBack;
        health--;
        double attackChance = Math.random();
        if (attackChance >= 0.5) {
            attackBack = true;
        } else {
            attackBack = false;
        }
        if (attackBack) {
            attack()
        }
    }
}
