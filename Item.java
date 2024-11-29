import java.util.Scanner;
import java.util.Random;

public class Item { // класс для представления оружия

    private String itemName;
    private int x, y;
    private boolean collected;
    private int damage;
    private Random random;

    // инициализация
    public Item() {
        System.out.println("Initializing Item...");
        this.random = new Random();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the item: ");
        itemName = scanner.nextLine();

        System.out.print("Enter the x-coordinate of the item: ");
        x = scanner.nextInt();

        System.out.print("Enter the y-coordinate of the item: ");
        y = scanner.nextInt();

        System.out.print("Enter the damage of the item: ");
        damage = scanner.nextInt();

        collected = false; // По умолчанию предмет не собран

        System.out.println("Item initialized successfully!");

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return itemName;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isCollected() {
        return collected;
    }

    public void collected() {
        collected = true;
    }

    public void move(int dx, int dy) {
        x = dx;
        y = dy;
    }

    public void moveRandom() {
        int dx = random.nextInt(15) + 1;
        int dy = random.nextInt(15) + 1;
        move(dx, dy);
    }

    // вывод характеристик оружия
    public void printItem() {
        System.out.printf("Item Position: (%d, %d)\n", x, y);
        System.out.printf("Item damage: %d\n", damage);
        System.out.printf("Is item collected: %s\n", collected ? "Yes" : "No");
    }
}
