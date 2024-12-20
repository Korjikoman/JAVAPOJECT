import java.util.Random;

class Potion { // класс для представления зелий восстановления
    private int x, y;
    private static int healthRestore;
    private boolean collected;
    private static final Random random = new Random();

    public Potion() {
        this(0, 0, false);
    }

    public Potion(int x, int y, boolean collected) {
        this.x = x;
        this.y = y;
        this.collected = collected;
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

    @Override
    public String toString() {
        return "Potion Position: (" + x + ", " + y + ")\n" +
                "Health Restore: " + healthRestore + "\n" +
                "Collected: " + (collected ? "Yes" : "No") + "\n";
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
