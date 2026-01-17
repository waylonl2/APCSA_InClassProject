public class Adventurer {
    private int health;
    private int mana;
    private Weapon weapon;
    private int missedAttackCount;

    public Adventurer(String weaponChoice) {
        health = 4;
        mana = 100;
        weapon = new Weapon(weaponChoice);
        missedAttackCount = 0;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setHealth(int num) {
        health = num;
    }

    public void setMana(int num) {
        mana = num;
    }

    public void setAttackCount(int num) {
        missedAttackCount = num;
    }

    public void attack(Monster monster) {
        boolean attackResult;
        int attackNum = (int) (Math.random() * 8) + 1;
        if (attackNum <= getWeapon().getPotency()) {
            attackResult = true;
            System.out.println("Attack successful!");
        } else {
            attackResult = false;
            System.out.println("Attack failed!");
        }
        missedAttackCount++;
        if (attackResult) {
            monster.turn(this);
            setAttackCount(0);
        } else if (missedAttackCount > 2) {
            System.out.println("Attack pity reached! Giving free attack... ");
            monster.turn(this);
            setAttackCount(0);
        }
    }

    public void heal() {
        if (getHealth() >= 4) {
            System.out.println("Max health already reached!");
        } else {
            setHealth(getHealth() + 1);
            System.out.println("Heal successful! Health is now " +  getHealth());
        }
    }

    public void enchant(int enchantValue) {
        for (int i = 0; i < enchantValue; i++) {
            if (getMana() - getWeapon().getManaCost() >= 0) {
                weapon.setPotency(weapon.getPotency() + 1);
                setMana(getMana() - weapon.getManaCost());
                System.out.println("Enchant successful!");
            } else {
                System.out.println("Enchant failed!");
                System.out.println("Adventurer has insufficient mana!");
            }
        }
        System.out.println("Weapon enchanted to " + getWeapon().getPotency() + " potency!");
    }

    public void lootMonster(Monster monster) {
        int lootedMana = (int) (Math.random() * 40) + 20;
        setMana(getMana() + lootedMana);
        System.out.println("Monster gave " + lootedMana + " mana!");
    }

    public void showStats() {
        System.out.println("--------------------");
        System.out.println("Adventurer stats");
        System.out.println("Health: " + getHealth());
        System.out.println("Mana: " + getMana());
        System.out.println("# of misses left before guaranteed attack (attack pity): " + (3 - missedAttackCount));
    }
}
