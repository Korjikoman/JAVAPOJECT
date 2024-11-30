
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int x, y;
    private Health health;
    private int speed;
    private int damage;
    private Inventory inventory;
    private int potions_count;
    private boolean is_alive;
    private int coins;

    // initialization
    public Player() {
        SecureMethods secure = new SecureMethods();
        int p_health;

        System.out.println("Initializing player...");

        System.out.print("Enter the initial x-coordinate of the player: ");
        x = secure.secureInt(0, 50);

        System.out.print("Enter the initial y-coordinate of the player: ");
        x = secure.secureInt(0, 50);

        System.out.print("Enter the initial health of the player: ");
        p_health = secure.secureInt(0, 50);
        health = new Health();
        health.changeHealthValue(p_health);
        health.changeMaxHealthValue(p_health);

        System.out.print("Enter the speed of the player: ");
        speed = secure.secureInt(0, 4);

        System.out.print("Enter the damage of the player: ");
        damage = secure.secureInt(0, 10);

        inventory = new Inventory();
        potions_count = 0; // Default initialization
        is_alive = true; // Player is alive when created
        coins = 0; // Initial coin count

        System.out.println("Player initialized successfully!");
    }

    // move the player
    public void movePlayer(int dx, int dy) {
        x = dx * speed;
        y = dy * speed;
        System.out.printf("Player moved to (%d, %d)%n", x, y);
    }

    // check if the player is alive
    public boolean isAlive() {
        return is_alive;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getspeed() {
        return speed;
    }

    public void printPlayer() {
        System.out.printf("Player Position: (%d, %d)%n", x, y);
        System.out.printf("Health: %d/%d%n", health.getCurrentHealth(), health.getMaxHealth());
        System.out.printf("Speed: %d%n", speed);
        System.out.printf("Player inventory space: %d, items count: %d%n", inventory.getSpace(),
                inventory.getItemsCount());
        System.out.printf("Player coins: %d%n", coins);
    }

    public int getDamage() {
        return damage;
    }

    public int getCurrentHealth() {
        return health.getCurrentHealth();
    }

    public int getMaxHealth() {
        return health.getMaxHealth();
    }

    public void changeHealthValue(int new_value) {
        health.changeHealthValue(new_value);
    }

    public void heal(int value) {
        health.heal(value);
    }

    public void is_dead() {
        is_alive = false;
    }

    public void damageMonster(Monsters monster, int damage) {
        monster.changeHealthValue(monster.getHealth() - damage);
        if (monster.getHealth() <= 0) {
            monster.changeHealthValue(0);
            monster.is_dead();
            System.out.println("Monster defeated!");
        }
    }
}