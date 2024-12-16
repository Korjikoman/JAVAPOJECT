import java.util.Random;
import java.util.Scanner;

public class Map {
    private static final int width = 50;
    private static final int height = 50;

    private Coin[] coins;
    private Monsters[] monsters;
    private Potion[] potions;
    private Player player = new Player();
    private Item[] items;
    private Inventory inventory;
    private int monsters_count;
    private int monster_index;
    private GameplayFunctions gameplay = new GameplayFunctions();

    private int items_count;
    private int item_index;

    private int potions_count;
    private int potion_index;

    private static final int coins_count = 7;
    private int coin_index;

    public Map() {
        System.out.print("How many monsters do you want");
        monsters_count = InputHandler.safeInt(1, 10);

        System.out.print("How many items do you want");
        items_count = InputHandler.safeInt(1, 10);

        System.out.print("How many potions do you want");
        potions_count = InputHandler.safeInt(1, 10);

        // Initializing objects, add it to the map
        monsters = new Monsters[monsters_count];
        for (int i = 0; i < monsters_count; i++) {
            monsters[i] = new Monsters();
        }

        items = new Item[items_count];
        for (int i = 0; i < items_count; i++) {
            items[i] = new Item();
        }
        potions = new Potion[potions_count];
        for (int i = 0; i < potions_count; i++) {
            potions[i] = new Potion();
        }
        coins = new Coin[coins_count];
        for (int i = 0; i < coins_count; i++) {
            coins[i] = new Coin();
        }
        moveObjectsRandomly();
        System.out.println("Map initialized successfully, objects added");
    }

    public int getPlayerHealth() {
        return player.getCurrentHealth();
    }

    public Map movePlayer(int dx, int dy) {
        player.movePlayer(dx, dy);
        return this;
    }

    public void showInitializedClasses() {
        System.out.println("------------------Player:");
        player.printPlayer();
        Inventory inventory = player.getInventory();
        System.out.println("------------------Player's inventory:");
        inventory.printInventory();

        System.out.println("------------------Monsters:");
        for (int i = 0; i < monsters_count; i++) {
            monsters[i].printMonster();
        }

        System.out.println("------------------Items:");
        for (int i = 0; i < items_count; i++) {
            items[i].printItem();
        }
        System.out.println("------------------Potions:");
        for (int i = 0; i < potions_count; i++) {
            potions[i].printPotion();
        }

        System.out.println("------------------Coins:");
        for (int i = 0; i < coins_count; i++) {
            coins[i].printCoin();
        }
    }

    public void checkCollisions() {
        Inventory inventory = player.getInventory();
        // Check collisions with monsters
        for (int i = 0; i < monsters_count; i++) {
            if (player.getX() == monsters[i].getX() && player.getY() == monsters[i].getY()) {
                System.out.println("Player encountered a monster!");
                gameplay.battleWithMonster(player, monsters[i]);
            }
        }

        // Check collisions with potions
        for (int i = 0; i < potions_count; i++) {
            if (player.getX() == potions[i].getX() && player.getY() == potions[i].getY()) {
                System.out.println("Player found a potion!");
                player.heal(Potion.getHealthRestore());
            }
        }

        // Check collisions with coins
        for (int i = 0; i < coins_count; i++) {
            if (player.getX() == coins[i].getX() && player.getY() == coins[i].getY()) {
                System.out.println("Player found a coin!");
                player.add_coins(5);
            }
        }

        // Check collisions with weapons
        for (int i = 0; i < items_count; i++) {
            if (player.getX() == items[i].getX() && player.getY() == items[i].getY()) {
                System.out.println("Player found a " + items[i].getName() + "!");
                player.addItems(items[i]);
            }
        }
    }

    public void moveObjectsRandomly() {
        for (int i = 0; i < monsters_count; i++) {
            monsters[i].setX((int) (Math.random() * 50));
            monsters[i].setY((int) (Math.random() * 50));
        }

        for (int i = 0; i < items_count; i++) {
            items[i].changeX((int) (Math.random() * 50));
            items[i].changeY((int) (Math.random() * 50));
        }

        for (int i = 0; i < potions_count; i++) {
            potions[i].changeX((int) (Math.random() * 50));
            potions[i].changeY((int) (Math.random() * 50));
        }

        for (int i = 0; i < coins_count; i++) {
            coins[i].changeX((int) (Math.random() * 50));
            coins[i].changeY((int) (Math.random() * 50));
        }
    }

    public Player getPlayer() {
        return player;
    }
}
