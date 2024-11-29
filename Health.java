public class Health {
    private int currentHealth;
    private int maxHealth;

    public Health() {
        this.currentHealth = 0;
        this.maxHealth = 0;
    }

    public Health(int max) {
        this.currentHealth = max;
        this.maxHealth = max;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void changeMaxHealthValue(int value) {
        maxHealth = value;
    }

    public void heal(int healPoints) {
        currentHealth += healPoints;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public void changeHealthValue(int newValue) {
        currentHealth = newValue;
    }
}
