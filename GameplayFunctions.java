import java.util.Scanner;

// ------------------- GAMEPLAY FUNCTIONS --------------------------
public class GameplayFunctions implements GameEntity {

    // This code is part of a game battle system using Java.
    @Override
    public void damagePlayer(Player player, int damage) {
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

    @Override
    public void damageMonster(Monsters monster, int damage) {
        monster.changeHealthValue(monster.getCurrentHealth() - damage);
        if (monster.getCurrentHealth() <= 0) {
            monster.changeHealthValue(0);
            monster.isDead();
            System.out.println("Monster defeated!");
        }
    }

    @Override
    public void battleWithMonster(Player player, Monsters monster) {
        if (!monster.isAlive()) {
            System.out.println("The monster is already dead.");
            return;
        }

        // Monster attacks first
        damagePlayer(player, monster.getDamage());
        System.out.println("You are attacked by a monster! Your health: " + player.getCurrentHealth());

        // Check if player is already dead
        if (player.getCurrentHealth() <= 0) {
            System.out.println("You were killed by the monster! Game over.");
            player.isDead();
            return;
        }

        int playerDamage = 0;
        Scanner scanner = new Scanner(System.in);
        if (player.getItemsCount() > 0) {
            // Player chooses a weapon from inventory
            System.out.print("Enter the name of the item: ");
            String itemName = scanner.nextLine();

            Item item = player.getItem(itemName);

            if (item != null) {
                playerDamage = item.getDamage();
                System.out.println("You've chosen a weapon " + item.getName() + " with damage: " + playerDamage);
            } else {
                System.out.println("Cannot find a weapon");
                playerDamage = player.getDamage();
                System.out.println("Your damage: " + playerDamage);
            }
        } else {
            System.out.println("You don't have any items");
            playerDamage = player.getDamage();
        }

        // Battle
        while (monster.isAlive() && player.isAlive()) {
            // Player attacks monster
            damageMonster(monster, playerDamage);
            System.out.println("You attacked the monster! Monster's health: " + monster.getCurrentHealth());

            if (!monster.isAlive()) {
                monster.isDead();
                break;
            }

            // Monster attacks player
            damagePlayer(player, monster.getDamage());
            System.out.println("The monster fought back! Your health: " + player.getCurrentHealth());

            if (player.getCurrentHealth() <= 0) {
                player.isDead();
                break;
            }
        }

        // Battle result
        if (!monster.isAlive() && player.isAlive()) {
            System.out.println("You killed the monster! You earned 5 coins!");
            player.add_coins(5);
        } else if (!player.isAlive()) {
            System.out.println("You were killed by the monster! Game over.");
        } else {
            System.out.println("ERROR: Unexpected condition in the battle.");
        }
        System.out.println("\n");
    }

    @Override
    public void changeSettings() {
        int choice;
        System.out.println("GAME SETTINGS");
        System.out.println("Select which setting you would like to change:");
        System.out.println("1) Player's maximum health");
        System.out.println("2) Maximum inventory space");

        choice = Integer.parseInt(System.console().readLine());
        switch (choice) {

            // ПОМЕНЯТЬ ЛОГИКУ 1го кейса
            case 1:
                int health;
                System.out.println("Enter new health value:");
                health = Integer.parseInt(System.console().readLine());
                Objects.setMaxHealth(health);
                System.out.println("The player's new max health value is: " + Objects.getMaxHealth());
                break;
            case 2:
                int space;
                System.out.println("Enter new max inventory space: ");
                space = Integer.parseInt(System.console().readLine());
                Inventory.changeSpace(space);
                System.out.println("The new max inventory space value is: " + Inventory.getSpace());
                break;

            default:
                break;
        }
    }
}