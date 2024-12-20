import java.util.Random;

class Coin extends Coordinates {
    private int value;
    private boolean collected;

    public Coin() {
        super(0, 0);
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

    @Override
    public String toString() {
        return String.format("Coin Position: (%d, %d)\n" +
                "Collected: %s\n", getX(), getY(), isCollected() ? "Yes" : "No");
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
