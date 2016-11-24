package designpatterns;

public class CharacterTest {
	
	    public static void main(String[] args) {
	       
	        Character d1 = new King();
	        d1.setWeapon(new KnifeBehavior());
	        d1.fight();
	        Character d2 = new Queen();
	        d2.setWeapon(new AxeBehavior());
	        d2.fight();
	        Character d3 = new Knight();
	        d3.setWeapon(new BowandArrowBehavior());
	        d3.fight();
	        Character d4 = new Troll();
	        d4.setWeapon(new SwordBehavior());
	        d4.fight();
	        
	    }
}
