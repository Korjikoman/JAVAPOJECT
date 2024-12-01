import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Initializing player...");

        System.out.println("Coordinates of a player: (" + x + "; " + y + ")");

        System.out.print("Enter the initial health of the player: ");
        int pHealth = scanner.nextInt();
        health.changeHealthValue(pHealth);

        System.out.print("Enter the speed of the player: ");
        speed = scanner.nextInt();

        System.out.print("Enter the damage of the player: ");
        damage = scanner.nextInt();

        potionsCount = 0; // Инициализация по умолчанию
        isAlive = true; // Игрок жив при создании
        coins = 0; // Начальное количество монет

        System.out.println("Player initialized successfully!");
    }

    // перемещаем игрока
    public void movePlayer(int dx, int dy) {
        x = dx * speed;
        y = dy * speed;
        System.out.printf("Player moved to (%d, %d)\n", x, y);
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

    public int getItem(int idx) {
        return inventory.getItem(idx);
    }
}
