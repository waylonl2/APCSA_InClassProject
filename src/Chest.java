public class Chest {
    private String chestType;
    private String[] loot;

    public Chest() {
        double chance = Math.random();
        if (chance < 0.75) {
            chestType = "common";
        } else {
            chestType = "rare";
        }
        if (chestType.equals("rare")) {
            loot = new String[] {"Gold", "Diamonds", "Magic 8 Ball"};
        } else if (chestType.equals("common")) {
            loot = new String[] {"Iron", "Coins", "Rusty Axe"};
        }
    }

    public String getChestType() {
        return chestType;
    }

    public String obtainLoot(int rewardChoice) {
        return loot[rewardChoice];
    }
}
