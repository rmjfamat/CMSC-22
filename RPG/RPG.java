package rpg;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Alvarez, Comparativo, Famat on 9/29/16.
 */

public class RPG {
	private Random rand = new Random();
	private static Scanner sc;

    public RPG() {
        this.rand = new Random();
    }
    
    // generate a random monster name..
    public String getRandomMonsterName() {
        String[] adjectives = {"Wild", "Crystal", "Giant", "Enchanted"};
        String[] monsters = {"Gargoyle", "Ghoul", "Hypogriff", "Golem"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);

        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    // inclusive random integer
    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    // coin toss
    public boolean coinToss() {
        return randInt(0, 1) == 1 ? true : false;
    }

    // pause the game for awhile for dramatic effect!
    public void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // duel two characters, one as attacker, one as defender
    // returns true if someone is killed

     public boolean monsteroffense(RPGCharacter attacker, RPGCharacter defender, int choice) {
    	Monster monster = (Monster) attacker; 
    	Hero hero = (Hero) defender;
     	int remHp = 0;
          
        System.out.println("--> " + attacker.getName() + " ATTACKED " + defender.getName());
        sleep(1000);
    	int monsterDamage = 0;
        int SRose = randInt(0,5);
         
        if (coinToss()) { 
        	if (choice == 1) {
        		monsterDamage = monster.attack();
        		remHp = defender.takeDamage(monsterDamage);
        	}
        	if (choice == 2) {
        		monsterDamage = monster.attack();
        		remHp = defender.takeDamage(monsterDamage);
        	}
        	if (choice == 3) {
        		if(SRose == 3) {
        			System.out.println("BUT MIC MIC ACTIVATED REFLECTION! \n");
                    sleep(1000);
                    System.out.println(attacker.getName() + " HURT ITSELF\n");
                    sleep(2500);
                    monsterDamage = monster.attack();
                    remHp = attacker.takeDamage(monsterDamage);
                    if (remHp <= 0) {
                    	System.out.println("\n"+attacker.getName()+" KILLED ITSELF");
 	                    sleep(1000);
 	                    return true;
                    }
                    return false;
        		}
        		else {
        			monsterDamage = monster.attack();
        			remHp = hero.takeDamage(monsterDamage);
        		}
        	}
        	if (choice == 4) {
        			monsterDamage = monster.attack();
        			remHp = defender.takeDamage(monsterDamage);
        	}
        	
        	if (remHp <= 0) {
        		System.out.printf("--> %s killed %s! \n ", attacker.getName(), defender.getName());
        		return true;
        	}  	
        
        }
         else {
            System.out.println("\n" +attacker.getName()+" MISSED!\n");
        }
        return false;
    }
    public boolean heroffense(RPGCharacter attacker, RPGCharacter defender, int choice){
    	Hero hero = (Hero) attacker; 
    	int remHp = 0;
    	int swordpower = randInt(0,1);	//Hero Swordsman
    	int bloodReplenish = randInt(0,5);	//Hero Fangs
    	int queenSA = randInt(0,3);	//Hero Fairy
    	int bomb = randInt(0,1);	//for Hero Dave
         
         System.out.println("--> " + attacker.getName() + " ATTACKED " + defender.getName());
         sleep(1000);
         int heroDamage = 0;
         
         if(coinToss()) {
        	 if(choice == 1) {
        		 if(bloodReplenish == 3) {
        			 heroDamage = hero.getSpecialAttack();
        			 hero.setHp(heroDamage);
        			 remHp = defender.takeDamage(heroDamage);
        			 System.out.println("\nFANG USED BLOOD REPLENISHMENT!\n");
                     sleep(2000);
        		 }
        		 else {
        			 heroDamage = attacker.attack();
        			 remHp = defender.takeDamage(heroDamage);
        		 }
        	 }
        	 
        	 if(choice == 2) {
        		 if(swordpower == 1) {
        			 heroDamage = hero.getSpecialAttack();
        			 remHp = defender.takeDamage(heroDamage);
        			 System.out.println("\nNICO USED SPECIAL ATTACK --> DOUBLE DAMAGE ACTIVATED!\n ");
                     sleep(2000);
        		 }
        		 else {
        			 heroDamage = hero.getAttack();
        			 remHp = defender.takeDamage(heroDamage);
        		 }
        	 }
        	 
        	 if(choice == 3) {
        		 if(queenSA == 2) {
        			 heroDamage = hero.getSpecialAttack();
        			 remHp = defender.takeDamage(heroDamage);
        			 System.out.println("\nMICMIC USED SPECIAL ATTACK! ");
                     sleep(2000);
                     System.out.println("\nSWOOOOOOOOOOOOSHHHH!\n ");
                     sleep(1000);
        		 }
        		 else {
        			 heroDamage = hero.getAttack();
        			 remHp = defender.takeDamage(heroDamage);
        		 }
        	 }
        	 if(choice == 4) {
        		 if(attacker.getHp() <= 10){ 
                     System.out.printf("D.A.V.E. used KAMIKAZE\n");
                     sleep(1000);
                     System.out.println("\n"+attacker.getName()+" and "+defender.getName()+" are both dead.");
                     sleep(1000);
                     return true;
                 }
        		 else if(bomb == 1) {
        			 heroDamage = hero.getSpecialAttack();
	        		 remHp = defender.takeDamage(heroDamage); 
	                 System.out.println((heroDamage)+"\n");
	                 System.out.println("\nD.A.V.E. launched VOLATILE MISSILES \n");
	                 sleep(1000);
	                 System.out.println("3... ");
	                 sleep(1000);
	                 System.out.println("2... ");
	                 sleep(1000);
	                 System.out.println("1... ");
	                 sleep(1000);
	                 System.out.println("BOOOOOOOM!\n");
	                 sleep(2000);
        		 }
        		 else {
        			 heroDamage = hero.getAttack();
        			 remHp = defender.takeDamage(heroDamage);
        		 }
        	 }
        	 
        	 if (remHp <= 0) {
                 System.out.printf("--> %s killed %s! \n ", attacker.getName(), defender.getName());
                 return true;
             }
         }
         else {
        	 System.out.println("\n" +attacker.getName()+" MISSED!\n");
         }
         
        return false;
    } 

    // game...
    public static void main(String[] args) {
        
        RPG rpg = new RPG();
        RPGCharacter hero;
      
        sc = new Scanner(System.in);
        int story;
        
        do{
        System.out.println(" 1. Storyline\n 2. Heroes' Characteristics\n");
        story = sc.nextInt();
        if (story == 1){
          System.out.println("The city of UP is on the hunt for monsters.");
          try {
              Thread.sleep(2000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
          System.out.println("Everyone is required to bring at least one monster head. ");
          try {
              Thread.sleep(2000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
          System.out.println("Choose a hero to assist you");
          try {
              Thread.sleep(1000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
          System.out.println("...");
          try {
              Thread.sleep(1000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
          System.out.println("Be careful who you choose.");
          try {
              Thread.sleep(1000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
          System.out.println("You will be bonded unbreakably to your chosen hero... Good luck!");
          try {
              Thread.sleep(1000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
        }
        else if(story == 2){
            System.out.println("\tNico the WISE Swordsman\n LEVEL: 5\n HP = 100\n BASE ATTACK: 5\n ARMOR: 10\n SPECIAL SKILL: Double Damage\n");
            try {
              Thread.sleep(2000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            System.out.println("\tRuffa the BROKEN Fangs\n LEVEL: 35\n HP: 50\n BASE ATTACK: 15\n ARMOR: 5\n SPECIAL SKILL: Replenish\n");
            try {
              Thread.sleep(2000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            System.out.println("\tMicMic the FAIREST of them all\n LEVEL: 35\n HP: 50\n BASE ATTACK: 20\n ARMOR: 10\n SPECIAL SKILL: Mirror\n");
            try {
              Thread.sleep(2000);
            } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
            }
            System.out.println("\tDave the DESTRUCTIVE ARMAMENT of VOLATILE EXPLOSIVES\n LEVEL: 60\n HP: 150\n BASE ATTACK: 15\n ARMOR: 10\n SPECIAL SKILL: Volatile Missiles\n");
            break;
          }
        }while(story != 2);
  
        
        System.out.println("Choose your hero:\n 1. Vampire \n 2. Swordsman \n 3. Fairy\n 4. D.A.V.E.\n");
        
        int choice = sc.nextInt();
        
        switch (choice) {
          case 1: {
             hero = new Fangs("Ruffa");
             break;
          }
          case 2: {
             hero = new Swordsman("Nico");  
             break;
          }
          case 3: {
            hero = new TheQueen("MicMic");
            break;
          }
          case 4: {
            hero = new Dave("D.A.V.E.");
            break;
          }
          default: {
            throw new IllegalArgumentException("Invalid input!");
          }
        }
        
        RPGCharacter monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(120, 150), rpg.randInt(15, 25));

        System.out.println("====== GAME START =====");
        System.out.printf("%s\n%s\n", hero, monster);

        // fight! for version 1, hero will always attack first.
        int count = 0;
        while (true) {
            System.out.println("\n== ROUND " + ++count +"\n");
            // hero's turn
            boolean monsterIsDead = rpg.heroffense(hero, monster, choice);
            if (monsterIsDead) break;

            // monster's turn
            boolean heroIsDead = rpg.monsteroffense(monster, hero, choice);
            if (heroIsDead) break;

            System.out.printf("\n%s\n%s\n", hero, monster);
        }

        System.out.printf("\n%s\n%s\n", hero, monster);
    }

}
