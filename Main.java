import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initializing map and objects on it
        Map map = new Map();

        // Game loop
        boolean gameRunning = true;

        while (gameRunning && map.getPlayerHealth() > 0) {
            System.out.println("\n\n");
            System.out.println("\n--- Game Menu ---");
            System.out.println("1. Move player");
            System.out.println("2. Show class objects");
            System.out.println("3. Change settings");
            System.out.println("4. Exit game");
            System.out.print("Enter your choice: ");

            int choice = InputHandler.safeInt(1, 4);

            switch (choice) {
                case 1: // Move the player to specified coordinates
                    System.out.print("Enter (x,y) to move the player");
                    int dx = InputHandler.safeInt(-100, 100);
                    int dy = InputHandler.safeInt(-100, 100);
                    if (map.getPlayer().getSpeed() == 2) {
                        map.movePlayer(dx, dy).movePlayer(dx, dy);
                    } else {
                        map.movePlayer(dx, dy);

                    }

                    map.checkCollisions();
                    break;
                case 2:
                    // Show classes and their characteristics
                    map.showInitializedClasses();
                    break;
                case 3:
                    GameplayFunctions.changeSettings();
                    break;
                case 4:
                    // Exit the game
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
