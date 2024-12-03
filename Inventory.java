import java.util.ArrayList;

public class Inventory { // класс для представления инвентаря игрока
    private static int space = 10;
    private int itemsCount;
    private int currentElement;
    private ArrayList<Item> inventoryItems;

    public Inventory() {
        System.out.println("Initializing Inventory...");

        inventoryItems = new ArrayList<>(space);

        itemsCount = 0;
        currentElement = 0;
    }

    public static int getSpace() {
        return space;
    }

    public static void changeSpace(int newSpace) {
        space = newSpace;
    }

    public int getCurrentElement() {
        return currentElement;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public ArrayList<Item> getInventoryItems() {
        return inventoryItems;
    }

    public void printInventory() {
        System.out.printf("Inventory space: %d\n", space);
        System.out.println("Your inventory:");
        if (itemsCount == 0) {
            System.out.println("There's nothing in it");
        }
        for (int i = 0; i < itemsCount; i++) {
            System.out.println("  Item " + (i + 1) + ": " + inventoryItems.get(i).getName());
        }
        System.out.println("Inventory current element: " + currentElement);
    }

    public int inventoryAddItem(Item item) {
        if (itemsCount >= space) {
            System.out.printf("Inventory is full! Cannot add item '%s'.\n", item.getName());
            return 0; // Не удалось добавить предмет
        }

        // Добавление предмета в массив строк
        inventoryItems.add(item);
        itemsCount++;

        item.isCollected(); // Помечаем предмет как собранный
        System.out.println("Item " + item.getName() + " added to inventory.");
        return 0;
    }

    public int getItem(int idx) {
        return inventoryItems.get(idx).getDamage();
    }
}
