public class Dave extends Hero {

    // because of sword
    private static final int BASE_ATTACK = 15;
    // because of armor
    private static final int ARMOR = 10;
    
    private static final int LEVEL = 60;
    
    private static final int Hp = 150;

    public Dave(String name) {
        super(name, Hp, LEVEL);
    }

    public int attack() {
        return BASE_ATTACK + (getLevel()/2);
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}