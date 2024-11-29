public class Coin { // class to represent coins
    private int x, y;
    private int value;
    private boolean collected;

    public Coin(int px, int py, int val) {
        this.x = px;
        this.y = py;
        this.value = val;
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
        System.out.println("Coin Position: (" + getX() + ", " + getY() + ")");
        System.out.println("Collected: " + (isCollected() ? "Yes" : "No"));
    }

    public boolean isCollected() {
        return collected;
    }

    public void collectCoin(Player player, int value) {
        if (!collected) {
            collected = true;
            player.add_coins(value);
            System.out.printf("Coin collected! Total coins: %d\n", player.get_coins());
        }
    }
}
