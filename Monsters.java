import java.util.Random;

public class Monsters extends Object {
    private String name;
    private static String[] names = { "Bob", "Dill", "Frank", "Sugarboy" };

    public Monsters() {
        Random rand = new Random();
        name = names[rand.nextInt(names.length)];
        setHealth(10);
        setDamage(5);
    }

    public void printMonster() {
        System.out.println("Monster Name: " + name);
        System.out.printf("Monster Position: (%d, %d)\n", getX(), getY());
        System.out.printf("Damage: %d\n", getDamage());
        System.out.printf("Health: %d\n", getCurrentHealth());
        System.out.printf("Is Alive: %s\n", isAlive() ? "Yes" : "No");
    }

    public void move(int dx, int dy) {
        setX(dx);
        setY(dy);
    }
}
