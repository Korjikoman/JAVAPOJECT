import java.util.Random;

class Potion extends Coordinates implements Cloneable { // класс для представления зелий восстановления
    private int healthRestore;
    private boolean collected;
    private static final Random random = new Random();

    public Potion() {
        this(0, 0, false);

        healthRestore = random.nextInt(20) + 1;
    }

    public Potion(int x, int y, boolean collected) {
        super(x, y);
        this.collected = collected;

        healthRestore = random.nextInt(20) + 1;
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

    public void setHealthRestore(int value) {
        healthRestore = value;
    }

    @Override
    public String toString() {
        return "Potion Position: (" + x + ", " + y + ")\n" +
                "Health Restore: " + healthRestore + "\n" +
                "Collected: " + (collected ? "Yes" : "No") + "\n";
    }

    @Override
    public Potion clone() throws CloneNotSupportedException {
        return (Potion) super.clone();
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

}
