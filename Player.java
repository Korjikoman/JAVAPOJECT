import java.util.List;
import java.util.Scanner;

public class Player extends Objects {
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

    @Override
    public String toString() {
        return String.format(
                "Player Position: (%d, %d)\n" +
                        "Health: %d/%d\n" +
                        "Speed: %d\n" +
                        "Player inventory space: %d, items count: %d\n" +
                        "Player has got %d potions\n" +
                        "Player coins: %d\n",
                getX(), getY(),
                getCurrentHealth(), getMaxHealth(),
                speed,
                Inventory.getSpace(), inventory.getItemsCount(),
                inventory.getPotionsCount(),
                coins);
    }

    public void addItems(Item item) {
        inventory.inventoryAddItem(item);
    }

    public int getItemsCount() {
        return inventory.getItemsCount();
    }

    public Item getItem(String itemName) {
        // Получаем список предметов из инвентаря
        List<List<Item>> items = inventory.getInventoryItems();

        // Перебираем все строки и слоты в инвентаре
        for (List<Item> row : items) {
            for (Item slot : row) {
                if (slot != null) {
                    // Выводим информацию о предмете
                    System.out.println("Item: " + slot.getName() + ", Damage: " + slot.getDamage());

                    // Проверяем, содержит ли имя предмета искомую строку
                    if (slot.getName().contains(itemName)) {
                        return slot; // Возвращаем найденный предмет
                    }
                }
            }
        }

        return null; // Если предмет не найден, возвращаем null
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