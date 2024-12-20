public class Object extends Coordinates {
    private int health;
    private static int maxHealth = 10;

    private int damage;
    private boolean is_alive;

    protected String name;

    public Object() {
        super(0, 0);
        this.health = 0;
        this.damage = 0;
        this.is_alive = true;
    }

    public Object(int x, int y, int health, int damage) {
        super(x, y);
        this.health = health;
        this.damage = damage;
        this.is_alive = true;
        System.out.println("Object initialized successfully!");
    }

    public static void setMaxHealth(int value) {
        maxHealth = value;
    }

    public void setHealth(int value) {
        health = value;
    }

    public boolean isAlive() {
        return is_alive;
    }

    public void isDead() {
        health = 0;
        is_alive = false;
    }

    public void changeHealthValue(int new_value) {
        health = new_value;
    }

    public int getCurrentHealth() {
        return health;
    }

    public static int getMaxHealth() {
        return maxHealth;
    }

    public void heal(int value) {
        health += value;
        System.out.println("Object's health restored");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int value) {
        x = value;
    }

    public void setY(int value) {
        y = value;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int value) {
        damage = value;
    }
}