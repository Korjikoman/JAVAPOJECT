import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static int space = 4;
    private int itemsCount;
    private int potionsCount;
    private int currentElement;

    private List<List<Item>> inventoryItems; // 2D список для предметов
    private List<Potion> inventoryPotions; // Список для зелий

    public Inventory() {
        System.out.println("Initializing Inventory...");
        itemsCount = 0;
        potionsCount = 0;
        currentElement = 0;

        // Размер инвентаря
        inventoryItems = new ArrayList<>();
        for (int i = 0; i < space / 2; i++) {
            List<Item> row = new ArrayList<>();
            for (int j = 0; j < space / 2; j++) {
                row.add(null);
            }
            inventoryItems.add(row);
        }

        inventoryPotions = new ArrayList<>();
        for (int i = 0; i < space; i++) {
            inventoryPotions.add(null);
        }
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

    public int getRow() {
        return itemsCount / (space / 2);
    }

    public int getCol() {
        return itemsCount % (space / 2);
    }

    public List<List<Item>> getInventoryItems() {
        return inventoryItems;
    }

    public void clearInventory() {
        // Очищаем все предметы в инвентаре
        for (List<Item> row : inventoryItems) {
            for (int i = 0; i < row.size(); i++) {
                row.set(i, null);
            }
        }

        // Очищаем все зелья
        for (int i = 0; i < inventoryPotions.size(); i++) {
            inventoryPotions.set(i, null);
        }

        // Сбрасываем счетчики
        itemsCount = 0;
        potionsCount = 0;
    }

    public void inventoryAddItem(Item item) {
        if (itemsCount >= space) {
            System.out.println("Inventory is full!");
            return;
        }

        // Ищем свободное место
        for (List<Item> row : inventoryItems) {
            for (int i = 0; i < row.size(); i++) {
                if (row.get(i) == null) {
                    row.set(i, item);
                    itemsCount++;
                    System.out.println("Item added");
                    return;
                }
            }
        }

        System.out.println("No space left to add item");
    }

    public void inventoryAddPotion(Potion potion) {
        if (potionsCount >= space) {
            System.out.println("No space left for potions");
            return;
        }

        // Добавляем в первый свободный слот
        for (int i = 0; i < inventoryPotions.size(); i++) {
            if (inventoryPotions.get(i) == null) {
                inventoryPotions.set(i, potion);
                potionsCount++;
                System.out.println("Potion added");
                return;
            }
        }

        System.out.println("No space left for potions");
    }

    public void usePotion() {
        if (potionsCount <= 0) {
            System.out.println("No potions left!");
            return;
        }

        // Используем последнее зелье
        inventoryPotions.set(potionsCount - 1, null);
        potionsCount--;
        System.out.println("Potion used! Potions left: " + potionsCount);
    }

    public int getPotionsCount() {
        return potionsCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventory (in matrix form):\n");

        // Выводим предметы в инвентаре
        for (List<Item> row : inventoryItems) {
            for (Item item : row) {
                if (item != null) {
                    sb.append(item.getName()).append(" ");
                } else {
                    sb.append("[Empty] ");
                }
            }
            sb.append("\n");
        }

        // Выводим зелия
        sb.append("Potions:\n");
        for (Potion potion : inventoryPotions) {
            if (potion != null) {
                sb.append("[Potion] ");
            } else {
                sb.append("[Empty] ");
            }
        }
        sb.append("\n");

        return sb.toString();
    }
}