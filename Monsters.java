import java.util.Random;

public class Monsters extends Objects {
    private static String[] names = { "Bob", "Dill", "Frank", "Sugarboy" };

    public Monsters() {
        Random rand = new Random();
        name = names[rand.nextInt(names.length)];
        setHealth(10);
        setDamage(5);
    }

    @Override
    public String toString() {
        return String.format(
                "Monster Name: %s\n" +
                        "Monster Position: (%d, %d)\n" +
                        "Damage: %d\n" +
                        "Health: %d\n" +
                        "Is Alive: %s\n",
                name,
                getX(), getY(),
                getDamage(),
                getCurrentHealth(),
                isAlive() ? "Yes" : "No");
    }

    public void move(int dx, int dy) {
        setX(dx);
        setY(dy);
    }
}
