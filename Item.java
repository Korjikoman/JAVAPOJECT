import java.util.Scanner;

class Item extends Coordinates { // class for representing a weapon

    private String itemName;
    private boolean collected;
    private int damage;

    // initialization
    public Item() {
        super(0, 0);
        System.out.println("Initializing Item...");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the item: ");
        itemName = InputHandler.safeString(100);

        System.out.print("Enter the damage of the item");
        damage = InputHandler.safeInt(1, 20);

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

    @Override
    public String toString() {
        return String.format("Coin Position: (%d, %d)\n" + "Item damage: %d\n" +
                "Collected: %s\n", x, y, damage, collected ? "Yes" : "No");

    }

    public void changeX(int value) {
        x = value;
    }

    public void changeY(int value) {
        y = value;
    }
}
