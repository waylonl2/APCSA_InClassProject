import java.util.Scanner;

public class DungeonFloor {
    private Scanner scan;
    private Adventurer adventurer;
    private Monster monster;
    private Chest chest;
    private int numMonsters = 0;

    public DungeonFloor() {
        scan = new Scanner(System.in);
        adventurer = null;
        monster = null;
        chest = new Chest();
        numMonsters = 0;
    }
    public void start() {
        System.out.println("Welcome adventurer, to the dungeon!");
        System.out.println("How to play:");
        System.out.println("Fight monsters (number of monsters is equal to the weight of your weapon");
        System.out.println("---------------------");
        System.out.println("Sword weight - 3");
        System.out.println("Mace weight - 4");
        System.out.println("Bow weight - 2");
        System.out.println("---------------------");
        System.out.println("Attacking does 1 damage, healing heals 1 HP");
        System.out.println("Attack is determined by weapon potency (higher potency means higher chance of dealing a successful attack)");
        System.out.println("Attack probability is weapon potency divided by 8");
        System.out.println("---------------------");
        System.out.println("Sword potency - 4");
        System.out.println("Mace potency - 6");
        System.out.println("Bow potency - 3");
        System.out.println("---------------------");
        System.out.println("Enchant your weapon to increase potency by 1 for one turn (costs mana and can enchant more than once for a turn)");
        System.out.println("Sword mana cost - 60");
        System.out.println("Mace mana cost - 80");
        System.out.println("Bow mana cost - 30");
        System.out.println("---------------------");
        System.out.println("Your adventurer starts with: 5 health and 100 mana");
        System.out.println("Choose your weapon (sword, mace, bow): ");
        String weapon = scan.nextLine();
        adventurer = new Adventurer(weapon);
        numMonsters = adventurer.getWeapon().getWeight();
        System.out.println("Let the dungeon crawl begin!");
        adventurer.getWeapon().showStats();
        for (int i = numMonsters; i > 0; i--) {
            if (!(gameOver())) {
                monster = new Monster();
                System.out.println("A monster appears!");
                while (!(monster.getHealth() == 0)) {
                    System.out.println("Enter 'a' to attack, 'h' to heal, 'e' to enchant, 's' to show stats, 'ws' for weapon stats: ");
                    String option = scan.nextLine();
                    if (option.equals("a")) {
                        adventurer.attack(monster);
                        adventurer.getWeapon().setPotency(adventurer.getWeapon().getOriginalPotency());
                    } else if (option.equals("h")) {
                        adventurer.heal();
                    } else if (option.equals("e")) {
                        System.out.println("How many times do you wish to enchant? ");
                        int enchantValue = scan.nextInt();
                        adventurer.enchant(enchantValue);
                        scan.nextLine();
                    } else if (option.equals("s")) {
                        adventurer.showStats();
                        monster.showStats();
                    } else if (option.equals("ws")) {
                        adventurer.getWeapon().showStats();
                    } else {
                        System.out.println("invalid option");
                    }
                    if (gameOver()) {
                        adventurer.showStats();
                        System.out.println("Game over! Adventurer died after health reached 0");
                        break;
                    }
                }
                if (gameOver()) {
                    adventurer.showStats();
                    System.out.println("Game over! Adventurer died after health reached 0");
                    break;
                }
                System.out.println("Monster defeated! Moving on... ");
                adventurer.lootMonster(monster);
            }
        }
        if (!gameOver()) {
            System.out.println("Congratulations! You've completed the dungeon!");
            System.out.println("Your reward is a " + chest.getChestType() + " level chest!");
            System.out.println("Pick your reward! (1, 2, or 3)");
            int rewardChoice = scan.nextInt();
            while (rewardChoice < 1 || rewardChoice > 3) {
                System.out.println("invalid option! Pick again!");
                System.out.println("Pick your reward! (1, 2, or 3)");
                rewardChoice = scan.nextInt();
            }
            System.out.println("You got " + chest.obtainLoot(rewardChoice - 1));
        }
    }

    public boolean gameOver() {
        if (adventurer.getHealth() == 0) {
            return true;
        }
        return false;
    }
}
