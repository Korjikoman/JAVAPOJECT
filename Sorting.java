import java.util.Comparator;
import java.util.List;

public class Sorting {

    public Sorting() {
        System.out.println("Sorting object created.");
    }

    // Метод для сортировки предметов по урону
    public static void sortItems(List<List<Item>> inventoryItems) {
        // Сортируем каждый ряд инвентаря
        for (List<Item> row : inventoryItems) {
            row.sort(new Comparator<Item>() {
                @Override
                public int compare(Item a, Item b) {
                    // Если оба элемента существуют, сортируем по урону
                    if (a != null && b != null) {
                        return Integer.compare(a.getDamage(), b.getDamage());
                    }
                    // Если один из элементов null, он должен быть в конце
                    return a != null ? -1 : 1; // a идет перед b, если a не null, а b null
                }
            });
        }
        System.out.println("Items sorted by damage.");
    }

    // Метод для сортировки зелий по количеству восстанавливаемого здоровья
    public static void sortPotions(List<Potion> inventoryPotions) {
        inventoryPotions.sort(new Comparator<Potion>() {
            @Override
            public int compare(Potion a, Potion b) {
                // Если оба элемента существуют, сортируем по убыванию здоровья
                if (a != null && b != null) {
                    return Integer.compare(b.getHealthRestore(), a.getHealthRestore()); // По убыванию
                }
                // Если один из элементов null, он должен быть в конце
                return a != null ? -1 : 1; // a идет перед b, если a не null, а b null
            }
        });
        System.out.println("Potions sorted by health restore.");
    }

    // Метод для сортировки предметов по имени
    public static void sortItemsByName(List<List<Item>> inventoryItems) {
        // Сортируем каждый ряд инвентаря
        for (List<Item> row : inventoryItems) {
            row.sort(new Comparator<Item>() {
                @Override
                public int compare(Item a, Item b) {
                    // Если оба элемента существуют, сортируем по имени
                    if (a != null && b != null) {
                        return a.getName().compareTo(b.getName());
                    }
                    // Если один из элементов null, он должен быть в конце
                    return a != null ? -1 : 1; // a идет перед b, если a не null, а b null
                }
            });
        }
        System.out.println("Items sorted by name.");
    }
}