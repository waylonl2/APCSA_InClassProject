public class Weapon {
    private int potency;
    private int weight;
    private int manaCost;
    private int originalPotency;
    private String weaponChoice;

    public Weapon(String weapon) {
        weaponChoice = weapon;
        if (weapon.equals("sword")) {
            potency = 4;
            weight = 3;
            manaCost = 60;
        } else if (weapon.equals("mace")) {
            potency = 6;
            weight = 4;
            manaCost = 80;
        } else if (weapon.equals("bow")) {
            potency = 3;
            weight = 2;
            manaCost = 50;
        } else {
            System.out.println("invalid weapon");
        }
        originalPotency = potency;
    }

    public int getPotency() {
        return potency;
    }

    public int getOriginalPotency() {
        return originalPotency;
    }

    public int getWeight() {
        return weight;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    public void showStats() {
        System.out.println("Weapon: " + weaponChoice);
        System.out.println("--------------------");
        System.out.println("Potency - " + potency);
        System.out.println("Weight - " + weight);
        System.out.println("Mana Cost - " + manaCost);
        System.out.println("--------------------");
    }
}
