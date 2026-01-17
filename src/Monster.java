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

    public void attackBuff() {
        attack++;
    }

    public void attack(Adventurer adventurer) {
        adventurer.setHealth(adventurer.getHealth() - 1);
        System.out.println("Monster attacks adventurer for " + getAttack());
    }

    public void turn(Adventurer adventurer) {
        setHealth(getHealth() - 1);
        System.out.println("Monster takes damage!");
        boolean attackBack;
        double attackChance = Math.random();
        if (attackChance >= 0.6) {
            attackBack = true;
        } else {
            attackBack = false;
        }
        if (attackBack) {
            attack(adventurer);
        }
        double buffChance = Math.random();
        if (buffChance >= 0.9) {
            attackBuff();
            System.out.println("Monster buffed itself! Attack went up by 1!");
        }
    }

    public void showStats() {
        System.out.println("--------------------");
        System.out.println("Monster's stats: ");
        System.out.println("Health: " + getHealth());
        System.out.println("Attack: " + getAttack());
    }
}
