import java.util.Arrays;

class Inventory { // класс для представления инвентаря игрока
    private static int space;
    private int itemsCount;
    private int currentElement;
    private Item[][] inventoryItems;
    private int cols;
    private int rows;

    public Inventory() {
        System.out.println("Initializing Inventory...");

        inventoryItems = new Item[Inventory.space][Inventory.space];
        cols = rows = Inventory.space / 2;
        for (int i = 0; i < Inventory.space; ++i) {
            Arrays.fill(inventoryItems[i], null); // Изначально все ячейки пустые (null)
        }

        itemsCount = 0;
        currentElement = 0;
    }

    public static int getSpace() {
        return space;
    }

    // Static method that changes inventory space
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

    // Выводим инвентарь
    public void printInventory() {
        System.out.println("Inventory (in matrix form):");
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (inventoryItems[i][j] != null) {
                    System.out.print(inventoryItems[i][j].getName()); // Выводим информацию о предмете
                } else {
                    System.out.print("[Empty]"); // Печатаем, если ячейка пустая
                }

                // Разделяем столбцы пробелом для читаемости
                System.out.print("\t");
            }
            System.out.println(); // Переход на новую строку после каждого ряда
        }
    }

    // Добавляем предмет в инвентарь
    public void inventoryAddItem(Item item) {
        if (itemsCount >= rows * cols) {
            System.out.println("Inventory is full!");
            return; // Предотвращаем добавление
        }

        int row = getRow();
        int col = getCol();

        // Проверяем, что позиция действительно свободна
        if (inventoryItems[row][col] != null) {
            System.out.println("Error: Slot (" + row + ", " + col + ") is already occupied.");
            return;
        }

        inventoryItems[row][col] = item; // Помещаем предмет
        itemsCount++;
        System.out.println("Item added to slot (" + row + ", " + col + ")");
    }

    public Item[][] getInventoryItems() {
        return inventoryItems;
    }

    static {
        space = 4; // Inventory space is a static variable
    }
}
