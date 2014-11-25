public class Entity implements Locatable{
    private Location loc;
    private String name;
    private int str;
    private int intel;
    private int dex;
    private int health;
    private static int numEntities = 0;
    public Entity(Location loc, String name, int str, int intel,
        int dex, int health) {
        this.loc = loc.deepCopy();
        this.name = name;
        this.str = str;
        this.intel = intel;
        this.dex = dex;
        this.health = health;
        numEntities++;

    }
    public Location getLoc() {
        return this.loc.deepCopy();
    }
    public void setLoc(Location loc) {
        this.loc = loc.deepCopy();
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return this.str;
    }
    public void setStr(int str) {
        this.str = str;
    }

    public int getIntel() {
        return this.intel;
    }
    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getDex() {
        return this.dex;
    }
    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getHealth() {
        return this.health;
    }
    public void setHealth(int health) {
        this.health = health;
    }


}
