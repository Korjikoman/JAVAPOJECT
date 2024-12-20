public abstract class Coordinates {
    protected int x;
    protected int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void location() {
        System.out.println("(" + x + "; " + y + ")");
    }

    public abstract int getX();

    public abstract int getY();
}