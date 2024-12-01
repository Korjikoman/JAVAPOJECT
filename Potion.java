import java.util.Random;

class Potion { // класс для представления зелий восстановления
    private int x, y;
    private static int healthRestore;
    private boolean collected;
    private static final Random random = new Random();

    public Potion() {
        this.x = 0;
        this.y = 0;
        this.collected = false;
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        collected = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getHealthRestore() {
        return healthRestore;
    }

    public static void setHealthRestore(int value) {
        healthRestore = value;
    }

    public void printPotion() {
        System.out.printf("Potion Position: (%d, %d)\n", x, y);
        System.out.printf("Health Restore: %d\n", healthRestore);
        System.out.printf("Collected: %s\n", collected ? "Yes" : "No");
    }

    public void move(int dx, int dy) {
        x = dx;
        y = dy;
    }

    // Генерируем случайные координаты зелья
    public void moveRandom() {
        int dx = random.nextInt(15) + 1;
        int dy = random.nextInt(15) + 1;
        move(dx, dy);
    }

    public void changeX(int value) {
        x = value;
    }

    public void changeY(int value) {
        y = value;
    }

    static {
        healthRestore = 4;
    }
}
