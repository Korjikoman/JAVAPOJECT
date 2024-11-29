import java.util.Random;

class Potion { // класс для представления зелий восстановления
    private int x, y;
    private int healthRestore;
    private boolean collected;
    private Random random;

    public Potion() {
        this.x = 0;
        this.y = 0;
        this.healthRestore = 4;
        this.collected = false;
        this.random = new Random();
    }

    public Potion(int px, int py, int restore) {
        this.x = px;
        this.y = py;
        this.healthRestore = restore;
        this.collected = false;
        this.random = new Random();
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

    public int getHealthRestore() {
        return healthRestore;
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

    public void moveRandom() {
        int dx = random.nextInt(15) + 1;
        int dy = random.nextInt(15) + 1;
        move(dx, dy);
    }
}
