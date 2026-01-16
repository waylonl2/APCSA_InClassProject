public class Weapon {
    private int potency;
    private int weight;
    private int manaCost;

    public Weapon(String weapon) {
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
            weight = 1;
            manaCost = 50;
        } else {
            System.out.println("invalid weapon");
        }
    }

    public int getPotency() {
        return potency;
    }

    public int getWeight() {
        return weight;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void enchant() {

        potency++;
    }
}
