public class Adventurer {
    private int health;
    private int mana;
    private Weapon weapon;
    private int attackCount;

    public Adventurer(String weaponChoice) {
        health = 3;
        mana = 100;
        weapon = new Weapon(weaponChoice);
        attackCount = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public void reduceHealth(int num) {
        health -= num;
    }

    public void reduceMana(int num) {
        mana -= num;
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void attack(Monster monster) {
        boolean attackResult;
        int attackNum = (int) (Math.random() * 8) + 1;
        if (attackNum <= getWeapon().getPotency()) {
            attackResult = true;
        } else {
            attackResult = false;
        }
        attackCount++;
        if (attackCount > 3) {
            kill(monster);
        } else {
            monster.round(attackResult);
        }
    }

    public void kill(Monster monster) {
        monster.setHealth(0);
    }
}
