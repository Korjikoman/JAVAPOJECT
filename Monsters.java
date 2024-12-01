import java.util.Random;

public class Monsters { // класс для представления монстров
    private int x, y;
    private int damage;
    private Health health = new Health();
    private boolean is_alive;

    public Monsters() {
        this.x = 0;
        this.y = 0;

        this.damage = 2;
        this.is_alive = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health.getCurrentHealth();
    }

    public void changeHealthValue(int value) {
        health.changeHealthValue(value);
    }

    public boolean isAlive() {
        return is_alive;
    }

    // вывод характеристик монстра
    public void printMonster() {
        System.out.printf("Monster Position: (%d, %d)\n", x, y);
        System.out.printf("Damage: %d\n", damage);
        System.out.printf("Health: %d\n", health.getCurrentHealth());
        System.out.printf("Is Alive: %s\n", is_alive ? "Yes" : "No");
    }

    public void move(int dx, int dy) {
        x = dx;
        y = dy;
    }

    public void changeX(int value) {
        x = value;
    }

    public void changeY(int value) {
        y = value;
    }

    public void is_dead() {
        is_alive = false;
    }

    public void damagePlayer(Player player, int damage) {
        if (!player.isAlive()) {
            System.out.println("Monster is dead and cannot attack.");
            return;
        }

        player.changeHealthValue(player.getCurrentHealth() - damage);
        if (player.getCurrentHealth() <= 0) {
            player.isDead();
            System.out.println("Player is dead");
        }
    }

}
