public abstract class Hero extends RPGCharacter {
    private int level;

    public Hero(String name, int hp, int level) {
        super(name, hp);
        this.level = level;
    }


    // getters and setters
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}