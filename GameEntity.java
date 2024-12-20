// --------------------- GAMEPLAY INTERFACE -------------------------

interface GameEntity {
    void damagePlayer(Player player, int damage);

    void damageMonster(Monsters monster, int damage);

    void battleWithMonster(Player player, Monsters monster);

    void changeSettings();
}
