import java.util.Scanner;

public class Player extends Object {
    private int speed;
    private Inventory inventory = new Inventory();
    private int potions_count;
    private int coins;

    public Player() {
        super();
        System.out.println("Initializing player...");
        System.out.println("Player's name (<= 100 characters): ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();

        System.out.println("Coordinates of a player: (0;0)");

        System.out.println("Enter the initial health of the player ");
        int init_health = scanner.nextInt();
        changeHealthValue(init_health);

        System.out.println("Enter the speed of the player ");
        speed = scanner.nextInt();

        System.out.println("Enter the damage of the player ");
        int init_damage = scanner.nextInt();
        setDamage(init_damage);

        potions_count = 0;
        coins = 0;

        System.out.println("Player " + name + " initialized successfully!");
    }

    public Player(String name, int x, int y, int health, int speed, int damage) {
        super(x, y, health, damage);
        System.out.println("Initializing player...");
        System.out.println("Player " + name + " initialized successfully!");
    }

    public Player movePlayer(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
        System.out.printf("Player moved to (%d, %d)\n", getX(), getY());
        return this;
    }

    public void printCoordinates() {
        System.out.println("Player is at (" + getX() + ", " + getY() + ")");
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void add_coins(int value) {
        coins += value;
    }

    public int get_coins() {
        return coins;
    }

    public int getspeed() {
        return speed;
    }

    public void printPlayer() {
        System.out.printf("Player Position: (%d, %d)\n", getX(), getY());
        System.out.printf("Health: %d/%d\n", getCurrentHealth(), getMaxHealth());
        System.out.printf("Speed: %d\n", speed);
        System.out.printf("Player inventory space: %d, items count: %d\n", Inventory.getSpace(),
                inventory.getItemsCount());
        System.out.printf("Player has got %d potions\n", inventory.getPotionsCount());
        System.out.printf("Player coins: %d\n", coins);
    }

    public void addItems(Item item) {
        inventory.inventoryAddItem(item);
    }

    public int getItemsCount() {
        return inventory.getItemsCount();
    }

    public Item getItem(String itemName) {
        Item[][] items = inventory.getInventoryItems();
        for (int i = 0; i < Inventory.getSpace(); i++) {
            for (int j = 0; j < Inventory.getSpace(); j++) {
                System.out.println("Item [" + (i + 1) + ";" + (j + 1) + "]" + items[i][j].getName() + ", Damage: "
                        + items[i][j].getDamage());
                if (items[i][j].getName().contains(itemName))
                    return items[i][j];
            }
        }
        return null;
    }

    public void heal() {
        if (inventory.getPotionsCount() > 0) {
            changeHealthValue(10);
            inventory.usePotion();
            System.out.println("Player used a potion. Potions left: " +
                    inventory.getPotionsCount());
        } else {
            System.out.println("No potions left to heal!");
        }

        // heal(5);
    }

    public String getName() {
        return name;
    }

    public void addPotion(Potion potion) {
        inventory.inventoryAddPotion(potion);
    }
}