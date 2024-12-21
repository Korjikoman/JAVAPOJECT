import java.util.List;
import java.util.Arrays;
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

    private CollisionsChecker<Monsters> monsterChecker = new CollisionsChecker<>();
    private CollisionsChecker<Potion> potionChecker = new CollisionsChecker<>();
    private CollisionsChecker<Coin> coinChecker = new CollisionsChecker<>();
    private CollisionsChecker<Item> itemChecker = new CollisionsChecker<>();

    private int items_count;
    private int item_index;

    private int potions_count;
    private int potion_index;

    private static final int coins_count = 7;
    private int coin_index;

    public Map() throws CloneNotSupportedException {
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
        Potion prototypePotion = new Potion();
        for (int i = 0; i < potions_count; i++) {
            potions[i] = prototypePotion;
            potions[i].x = 1;
            potions[i].y = 2;

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
        System.out.println(player);
        Inventory inventory = player.getInventory();
        System.out.println("------------------Player's inventory:");
        System.out.println(inventory);

        System.out.println("------------------Monsters:");
        for (int i = 0; i < monsters_count; i++) {
            System.out.println(monsters[i]);
        }

        System.out.println("------------------Items:");
        for (int i = 0; i < items_count; i++) {
            System.out.println(items[i]);
        }
        System.out.println("------------------Potions:");
        for (int i = 0; i < potions_count; i++) {
            System.out.println(potions[i]);
        }

        System.out.println("------------------Coins:");
        for (int i = 0; i < coins_count; i++) {
            System.out.println(coins[i]);
        }
    }

    public void checkCollisions() {

        monsterChecker.checkCollisions(player, Arrays.asList(monsters), (player, monster) -> {
            System.out.println("Player encountered a monster!");
            gameplay.battleWithMonster(player, monster);
        });

        // Check for collisions with potions
        potionChecker.checkCollisions(player, List.of(potions), (player, potion) -> {
            System.out.println("Player found a potion!");
            player.addPotion(potion);
            potion.collect();
        });

        // Check for collisions with coins
        coinChecker.checkCollisions(player, List.of(coins), (player, coin) -> {
            System.out.println("Player found a coin!");
            coin.collectCoin(player, 5);
            player.add_coins(5);
        });

        // Check for collisions with items
        itemChecker.checkCollisions(player, List.of(items), (player, item) -> {
            System.out.println("Player found a " + item.getName() + "!");
            player.addItems(item);
        });
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
