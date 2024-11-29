import java.util.Scanner;

public class Inventory {
    private int space;
    private int itemsCount;
    private int currentElement;
    private Item[] inventoryItems;

    public Inventory() {
        System.out.println("Initializing Inventory...");

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the inventory space: ");
        space = scan.nextInt();

        if (space <= 0) {
            System.err.println("Invalid inventory size! Setting space to 1.");
            space = 1;
        }
        inventoryItems = new Item[space];

        itemsCount = 0;
        currentElement = 0;
    }

    public int getSpace() {
        return space;
    }

    public void changeSpace(int newSpace) {
        space = newSpace;
    }

    public int getCurrentElement() {
        return currentElement;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void printInventory() {
        System.out.printf("Inventory space: %d\n", space);
        System.out.println("Your inventory:");
        if (itemsCount == 0)
            System.out.println("There's nothing in it");
        for (int i = 0; i < itemsCount; i++) {
            System.out.println("  Item " + (i + 1) + ": " + inventoryItems[i].getName());
        }
        System.out.println("Inventory current element: " + currentElement);
    }

    public int inventoryAddItem(Item item) {
        if (itemsCount >= space) {
            System.out.printf("Inventory is full! Cannot add item '%s'.\n", item.getName());
            return 0; // Failed to add item
        }

        // Add item to the array
        inventoryItems[itemsCount] = item;
        itemsCount++;

        item.collected(); // Mark the item as collected
        System.out.println("Item " + item.getName() + " added to inventory.");
        return 0;
    }

    public int getItem(int idx) {
        return inventoryItems[idx].getDamage();
    }
}
