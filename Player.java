import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Player { // класс для представления игрока

    private int x, y;
    private Health health = new Health();
    private int speed;
    private int damage;
    private Inventory inventory = new Inventory();
    private int potionsCount;

    private boolean isAlive;
    private int coins;

    // инициализация
    public Player() {
        System.out.println("Initializing player...");

        System.out.println("Coordinates of a player: (" + x + "; " + y + ")");

        System.out.print("Enter the initial health of the player");
        int pHealth = InputHandler.safeInt(1, 10);
        health.changeHealthValue(pHealth);

        System.out.print("Enter the speed of the player");
        speed = InputHandler.safeInt(1, 2);

        System.out.print("Enter the damage of the player");
        damage = InputHandler.safeInt(1, 2);

        potionsCount = 0; // Инициализация по умолчанию
        isAlive = true; // Игрок жив при создании
        coins = 0; // Начальное количество монет

        System.out.println("Player initialized successfully!");
    }

    // перемещаем игрока
    public Player movePlayer(int x, int y) {
        this.x = x * speed;
        this.y = y * speed;
        System.out.printf("Player moved to (%d, %d)\n", x, y);
        return this;
    }

    // проверяем, умер ли игрок
    public boolean isAlive() {
        return isAlive;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addCoins(int value) {
        coins += value;
    }

    public int getCoins() {
        return coins;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public void printPlayer() {
        System.out.printf("Player Position: (%d, %d)\n", x, y);
        System.out.printf("Health: %d/%d\n", health.getCurrentHealth(), health.getMaxHealth());
        System.out.printf("Speed: %d\n", speed);
        System.out.printf("Player inventory space: %d, items count: %d\n", inventory.getSpace(),
                inventory.getItemsCount());
        System.out.printf("Player coins: %d\n", coins);
    } // вывод игрока

    public int getDamage() {
        return damage;
    }

    public int getCurrentHealth() {
        return health.getCurrentHealth();
    }

    public int getMaxHealth() {
        return health.getMaxHealth();
    }

    public void changeHealthValue(int newValue) {
        health.changeHealthValue(newValue);
    }

    public void heal(int value) {
        health.heal(value);
    }

    public void isDead() {
        isAlive = false;
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

}
