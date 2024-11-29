import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Инициализируем объекты класса
        Player player = new Player();
        Inventory inventory = player.getInventory();

        Scanner scan = new Scanner(System.in);

        System.out.print("How many monsters do you want: ");
        int monstersCount = scan.nextInt();

        System.out.print("How many items do you want: ");
        int itemsCount = scan.nextInt();

        System.out.print("How many potions do you want: ");
        int potionCount = scan.nextInt();

        // Инициализировали монстров, переместили их в рандомные места
        Monsters[] monsters = new Monsters[monstersCount];
        for (int i = 0; i < monstersCount; i++) {
            monsters[i] = new Monsters();
            monsters[i].move_random();
        }

        Item[] items = new Item[itemsCount];
        for (int i = 0; i < potionCount; i++) {
            items[i] = new Item();
        }

        Potion[] potions = new Potion[potionCount];
        for (int i = 0; i < potionCount; i++) {
            potions[i] = new Potion();
            potions[i].moveRandom();
        }

        Coin coin = new Coin(3, 3, 5);

        // Игровой цикл
        boolean gameRunning = true;
        while (gameRunning && player.getCurrentHealth() > 0) {
            GameplayFunctions game_functions = new GameplayFunctions();
            System.out.println("\n\n");
            System.out.println("\n--- Game Menu ---");
            System.out.println("1. Move player");
            System.out.println("2. Show class objects");
            System.out.println("3. Exit game");
            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1: // Перемещаем игрока по указанным координатам
                    System.out.print("Enter (x,y) to move the player: ");
                    int dx = scan.nextInt();
                    int dy = scan.nextInt();
                    player.movePlayer(dx, dy);
                    game_functions.checkCollisions(player, monsters, potions, coin, inventory, items);
                    break;
                case 2:
                    // Показываем классы и их характеристику
                    game_functions.showInitializedClasses(player, inventory, monsters, items, potions, coin);
                    break;
                case 3:
                    // Выход из игры
                    gameRunning = false;
                    System.out.println("Exiting the game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scan.close();
    }
}
