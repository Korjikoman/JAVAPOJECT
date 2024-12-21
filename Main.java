import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Инициализируем объекты класса

        // initializing map and objects on it
        Map map = new Map();
        Player player = map.getPlayer();
        GameplayFunctions gameplay = new GameplayFunctions();
        // Game loop
        boolean gameRunning = true;
        while (gameRunning && player.getCurrentHealth() > 0) {
            System.out.println("\n\n");
            System.out.println("\n--- Game Menu ---");
            System.out.println("1. Move player");
            System.out.println("2. Show class objects");
            System.out.println("3. Use potion to restore health");
            System.out.println("4. Change settings");
            System.out.println("5. Exit game");
            System.out.print("Enter your choice: ");
            int choice = InputHandler.safeInt(1, 5);

            switch (choice) {
                case 1: // Перемещаем игрока по указанным координатам
                    int dx, dy;
                    System.out.print("Enter (x,y) to move the player: ");
                    int[] result = InputHandler.safeMultipleInt();
                    dx = result[0];
                    dy = result[1];
                    map.movePlayer(dx, dy);
                    map.checkCollisions();
                    break;
                case 2:
                    // Показываем классы и их характеристику
                    map.showInitializedClasses();
                    break;
                case 3:
                    player.heal();
                    System.out.println("DONE");
                    break;
                case 4:
                    gameplay.changeSettings();
                    break;
                case 5:
                    // Выход из игры
                    gameRunning = false;
                    System.out.println("Exiting the game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
