import java.util.List;

public class CollisionsChecker<T extends Coordinates> {
    public void checkCollisions(Player player, List<T> objects, CollisionHandler<T> handler) {
        for (T object : objects) {
            if (player.getX() == object.getX() && player.getY() == object.getY()) {
                handler.handleCollision(player, object);
            }
        }
    }
}

@FunctionalInterface
interface CollisionHandler<T> {
    void handleCollision(Player player, T object);
}
