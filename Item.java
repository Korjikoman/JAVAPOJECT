import java.util.Scanner;

class Item { // class for representing a weapon

    private String itemName;
    private int x, y;
    private boolean collected;
    private int damage;

    // initialization
    public Item() {
        System.out.println("Initializing Item...");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the item: ");
        itemName = scanner.nextLine();

        System.out.print("Enter the damage of the item: ");
        damage = scanner.nextInt();

        collected = false; // By default, the item is not collected
        x = 0;
        y = 0;
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

    // output item characteristics
    public void printItem() {
        System.out.printf("Item Position: (%d, %d)\n", x, y);
        System.out.printf("Item damage: %d\n", damage);
        System.out.printf("Is item collected: %s\n", collected ? "Yes" : "No");
    }

    public void changeX(int value) {
        x = value;
    }

    public void changeY(int value) {
        y = value;
    }
}
