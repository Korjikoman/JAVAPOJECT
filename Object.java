import java.util.Random;

class Object { // класс для представления объектов. Является родительским к классам Player and
               // Monster
    private int x, y;
    private int health;
    private static int maxHealth = 10;

    private int damage;
    private boolean is_alive;

    protected String name; // Имя объекта

    public Object() {
        this.x = 0;
        this.y = 0;
        this.health = 0;
        this.damage = 0;
        this.is_alive = true;
    }

    public Object(int x, int y, int health, int damage) {
        this.x = x;
        this.y = y;
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

    public int getCurrentHealth() {
        return health;
    }

    public void changeHealthValue(int new_value) {
        health = new_value;
    }

    public static int getMaxHealth() {
        return maxHealth;
    }

    public void heal(int value) {
        health += value;
        System.out.println("Object's health restored");
    }
}
