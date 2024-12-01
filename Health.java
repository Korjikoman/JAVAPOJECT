
public class Health { // Class for representing player health
    private int currentHealth;
    private static int maxHealth = 10;

    public Health() {
        currentHealth = maxHealth;
    }

    public static void setMaxHealth(int newSize) {
        maxHealth = newSize;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public static int getMaxHealth() {
        return maxHealth;
    }

    public void heal(int healPoints) {
        currentHealth += healPoints;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public void changeHealthValue(int newValue) { // Change the current health value
        currentHealth = newValue;
    }
}