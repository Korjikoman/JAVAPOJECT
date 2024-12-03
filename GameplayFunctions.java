import java.util.Scanner;

// ------------------- GAMEPLAY FUNCTIONS --------------------------
public class GameplayFunctions {

    // This code is part of a game battle system using Java.

    public static void damagePlayer(Player player, int damage) {
        if (!player.isAlive()) {
            System.out.println("Monster is dead and cannot attack.");
            return;
        }

        player.changeHealthValue(player.getCurrentHealth() - damage);
        if (player.getCurrentHealth() <= 0) {
            player.isDead();
            System.out.println("Player is dead");
        }
    }

    public static void damageMonster(Monsters monster, int damage) {
        monster.changeHealthValue(monster.getHealth() - damage);
        if (monster.getHealth() <= 0) {
            monster.changeHealthValue(0);
            monster.is_dead();
            System.out.println("Monster defeated!");
        }
    }

    public void battleWithMonster(Player player, Monsters monster) {
        if (!monster.isAlive()) {
            System.out.println("The monster is already dead.");
            return;
        }

        // Monster attacks first
        damagePlayer(player, monster.getDamage());
        System.out.printf("You are attacked by a monster! Your health: %d\n", player.getCurrentHealth());

        // Check if the player is already dead
        if (player.getCurrentHealth() <= 0) {
            System.out.println("You were killed by the monster! Game over.\n");
            player.isDead();
            return;
        }

        int playerDamage = 0;
        if (player.getItemsCount() > 0) {
            // Player chooses a weapon from the inventory
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the name of the item: ");
            String itemName = scanner.nextLine();

            Item item = player.getItem(itemName);

            if (item != null) {
                playerDamage = item.getDamage();
                System.out.printf("You've chosen a weapon %s with damage: %d\n", item.getName(), playerDamage);
            } else {
                System.out.println("Cannot find a weapon");
                playerDamage = player.getDamage();
                System.out.printf("Your damage: %d\n", playerDamage);
            }
        } else {
            System.out.println("You don't have any items");
            playerDamage = player.getDamage();
        }

        // Battle
        while (monster.isAlive() && player.isAlive()) {
            // Player attacks the monster
            damageMonster(monster, playerDamage);
            System.out.printf("You attacked the monster! Monster's health: %d\n", monster.getHealth());

            if (!monster.isAlive()) {
                monster.changeX(-1);
                monster.changeY(-1);
                break;
            }

            // Monster attacks the player
            damagePlayer(player, monster.getDamage());
            System.out.printf("The monster fought back! Your health: %d\n", player.getCurrentHealth());

            if (player.getCurrentHealth() <= 0) {
                player.isDead();
                break;
            }
        }

        // Battle result
        if (!monster.isAlive() && player.isAlive()) {
            System.out.println("You killed the monster! You earned 5 coins!\n");
            player.addCoins(5);
        } else if (!player.isAlive()) {
            System.out.println("You were killed by the monster! Game over.\n");
        } else {
            System.out.println("ERROR: Unexpected condition in the battle.\n");
        }
        System.out.println("\n");
    }

    // Use potion to restore health
    public static void usePotion(Player player, Potion potion) {
        if (potion.isCollected() || potion.getHealthRestore() <= 0)
            return;

        System.out.println("Player found a potion! Restoring " + potion.getHealthRestore() + " health.");
        player.changeHealthValue(player.getCurrentHealth() + potion.getHealthRestore());
        if (player.getCurrentHealth() > player.getMaxHealth()) {
            player.changeHealthValue(player.getMaxHealth());
        }
        potion.collect();
    }

    public static void changeSettings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("GAME SETTINGS");
        System.out.println("Select which setting you would like to change:");
        System.out.println("1) Player's maximum health");
        System.out.println("2) Maximum inventory space");
        System.out.println("3) Amount of health restored by potions");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter new health value: ");
                int health = scanner.nextInt();
                Health.setMaxHealth(health);
                System.out.println("The player's new max health value is: " + Health.getMaxHealth() + "\n");
                break;

            case 2:
                System.out.print("Enter new max inventory space: ");
                int space = scanner.nextInt();
                Inventory.changeSpace(space);
                System.out.println("The new max inventory space value is: " + Inventory.getSpace() + "\n");
                break;

            case 3:
                System.out.print("Enter new restored health value: ");
                int restore = scanner.nextInt();
                Potion.setHealthRestore(restore);
                System.out.println("The new value of the player's maximum health: " + Potion.getHealthRestore() + "\n");
                break;

            default:
                break;
        }
    }
}