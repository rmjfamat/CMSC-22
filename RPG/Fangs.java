public class Fangs extends Hero {

    // because of sword
    private static final int BASE_ATTACK = 15;
    // because of armor
    private static final int ARMOR = 0;
    
    private static final int LEVEL = 35;
    
    private static final int Hp = 50;

    public Fangs(String name) {
        super(name, Hp , LEVEL);
    }

    public int attack() {
        return BASE_ATTACK + ( getLevel()/2);
    }

    public int takeDamage(int damage) {
        // reduce damage because of armor!!! oh yeah!
        damage -= ARMOR;
        // set new hp
        return super.takeDamage(damage);
    }
}