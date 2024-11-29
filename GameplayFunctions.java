import java.util.Scanner;

// ------------------- GAMEPLAY FUNCTIONS --------------------------
public class GameplayFunctions {

    public void battleWithMonster(Player player, Monsters monster, Inventory inventory) {
        if (!monster.isAlive()) {
            System.out.println("The monster is already dead.");
            return;
        }

        monster.damagePlayer(player, monster.getDamage());
        System.out.printf("You are attacked by a monster! Your health: %d\n", player.getCurrentHealth());

        if (player.getCurrentHealth() <= 0) {
            System.out.println("You were killed by the monster! Game over.\n");
            player.is_dead();
            return;
        }

        int playerDamage = 0;
        if (inventory.getItemsCount() > 0) {
            System.out.printf("Choose a weapon from your inventory (enter slot number 1-%d): \n",
                    inventory.getItemsCount());
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice < 1 || choice > inventory.getItemsCount()) {
                System.out.println("Invalid choice. You lose your chance to attack!\n");
                return;
            }

            playerDamage = inventory.getItem(choice - 1);
            System.out.printf("You've chosen a weapon with damage: %d\n", playerDamage);
        } else {
            System.out.println("You don't have any items");
            playerDamage = player.getDamage();
        }

        while (monster.isAlive() && player.isAlive()) {
            player.damageMonster(monster, playerDamage);
            System.out.printf("You attacked the monster! Monster's health: %d\n", monster.getHealth());

            if (!monster.isAlive()) {
                monster.changeX(-1);
                monster.changeY(-1);
                break;
            }

            monster.damagePlayer(player, monster.getDamage());
            System.out.printf("The monster fought back! Your health: %d\n", player.getCurrentHealth());

            if (player.getCurrentHealth() <= 0) {
                player.is_dead();
                break;
            }
        }

        if (!monster.isAlive() && player.isAlive()) {
            System.out.println("You killed the monster! You earned 5 coins!\n");
            player.add_coins(5);
        } else if (!player.isAlive()) {
            System.out.println("You were killed by the monster! Game over.\n");
        } else {
            System.out.println("ERROR: Unexpected condition in the battle.\n");
        }
        System.out.println("\n");
    }

    public void usePotion(Player player, Potion potion) {
        if (potion.isCollected() || potion.getHealthRestore() <= 0)
            return;

        System.out.printf("Player found a potion! Restoring %d health.\n", potion.getHealthRestore());

        player.changeHealthValue(player.getCurrentHealth() + potion.getHealthRestore());
        if (player.getCurrentHealth() > player.getMaxHealth()) {
            player.changeHealthValue(player.getMaxHealth());
        }
        potion.collect();
    }

    public void checkCollisions(Player player, Monsters[] monsters, Potion[] potions,
            Coin coin, Inventory inventory, Item[] items) {
        for (Monsters monster : monsters) {
            if (player.getX() == monster.getX() && player.getY() == monster.getY()) {
                System.out.println("Player encountered a monster!");
                battleWithMonster(player, monster, inventory);
            }
        }

        for (Potion potion : potions) {
            if (player.getX() == potion.getX() && player.getY() == potion.getY()) {
                System.out.println("Player found a potion!");
                player.heal(potion.getHealthRestore());
            }
        }

        if (player.getX() == coin.getX() && player.getY() == coin.getY()) {
            System.out.println("Player found a coin!");
            player.add_coins(coin.getValue());
        }

        for (Item item : items) {
            if (player.getX() == item.getX() && player.getY() == item.getY()) {
                System.out.printf("Player found a %s!\n", item.getName());
                inventory.inventoryAddItem(item);
            }
        }
    }

    public void showInitializedClasses(Player player, Inventory inventory, Monsters[] monsters,
            Item[] items, Potion[] potions, Coin coin) {
        System.out.println("------------------Player:");
        player.printPlayer();

        System.out.println("------------------Player's inventory:");
        inventory.printInventory();

        System.out.println("------------------Monsters:");
        for (Monsters monster : monsters) {
            monster.printMonster();
        }

        System.out.println("------------------Items:");
        for (Item item : items) {
            item.printItem();
        }

        System.out.println("------------------Potions:");
        for (Potion potion : potions) {
            potion.printPotion();
        }

        System.out.println("------------------Coin:");
        coin.printCoin();
    }
}
