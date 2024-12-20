public class Inventory { // класс для представления инвентаря игрока
    private static int space = 4;
    private int itemsCount;
    private int potionsCount;
    private int currentElement;
    private Item[][] inventoryItems;
    private Potion[] inventoryPotions;
    private int cols;
    private int rows;

    public Inventory() {
        System.out.println("Initializing Inventory...");

        inventoryItems = new Item[space][space];
        cols = rows = space / 2;
        for (int i = 0; i < space; ++i) {
            for (int j = 0; j < space; ++j) {
                inventoryItems[i][j] = null; // Изначально все ячейки пустые (null)
            }
        }

        inventoryPotions = new Potion[space];

        for (int i = 0; i < space; ++i) {
            inventoryPotions[i] = null; // Изначально все ячейки пустые (null)
        }

        itemsCount = 0;
        currentElement = 0;
        potionsCount = 0;
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
        return itemsCount / cols;
    }

    public int getCol() {
        return itemsCount % cols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Inventory (in matrix form):\n");
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (inventoryItems[i][j] != null) {
                    sb.append(inventoryItems[i][j].getName()); // Выводим информацию о предмете
                } else {
                    sb.append("[Empty]"); // Печатаем, если ячейка пустая
                }
                sb.append("\t");
            }
            sb.append("\n"); // Переход на новую строку после каждого ряда
        }

        sb.append("Potions:\n");
        for (int i = 0; i < rows; ++i) {
            if (inventoryPotions[i] != null) {
                sb.append("[Potion]"); // Выводим информацию о предмете
            } else {
                sb.append("[Empty]"); // Печатаем, если ячейка пустая
            }
            sb.append("\t");
        }
        sb.append("\n");

        return sb.toString();
    }

    public void inventoryAddItem(Item item) {
        if (itemsCount >= rows * cols) {
            System.out.println("Inventory is full!");
            return; // Предотвращаем добавление
        }

        int row = getRow();
        int col = getCol();

        if (inventoryItems[row][col] != null) {
            System.out.println("Error: Slot (" + row + ", " + col + ") is already occupied.");
            return;
        }

        inventoryItems[row][col] = item; // Помещаем предмет
        itemsCount++;
        System.out.println("Item added to slot (" + row + ", " + col + ")");
    }

    public void inventoryAddPotion(Potion potion) {
        if (potionsCount >= space) {
            System.out.println("Inventory is full!");
            return; // Предотвращаем добавление
        }

        if (inventoryPotions[potionsCount] != null) {
            System.out.println("Error: Slot (" + potionsCount + ") is already occupied.");
            return;
        }

        inventoryPotions[potionsCount] = potion; // Помещаем предмет
        potionsCount++;
        System.out.println("Potion added to slot (" + potionsCount + ")");
    }

    public void usePotion() {
        if (potionsCount <= 0) {
            System.out.println("No potions left!");
            return;
        }

        inventoryPotions[potionsCount - 1].changeX(-1);
        inventoryPotions[potionsCount - 1].changeY(-1);

        inventoryPotions[potionsCount - 1] = null;

        potionsCount--;
        System.out.println("Potion used! Potions left: " + potionsCount);
    }

    public int getPotionsCount() {
        return potionsCount;
    }

    public Item[][] getInventoryItems() {
        return inventoryItems;
    }

    public Potion[] getPotions() {
        return inventoryPotions;
    }
}