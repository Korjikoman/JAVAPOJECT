import java.util.Random;

class Coin {
    private int x, y;
    private int value;
    private boolean collected;

    public Coin() {
        this.x = 0;
        this.y = 0;
        this.value = 5;
        this.collected = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public void printCoin() {
        System.out.println("Coin Position: (" + x + ", " + y + ")");
        System.out.println("Collected: " + (isCollected() ? "Yes" : "No"));
    }

    public boolean isCollected() {
        return collected;
    }

    public void collectCoin(Player player, int value) {
        if (!collected) {
            collected = true;
            player.add_coins(value);
            System.out.printf("Coin collected! Total coins: %d%n", player.get_coins());
        }
    }

    public void changeX(int value) {
        x = value;
    }

    public void changeY(int value) {
        y = value;
    }
}
