public class Item extends Entity {
    private int base;
    public Item(Location loc, String name, int str, int intel,
        int dex, int health, int base) {
        super(loc, name, str, intel, dex, health);
        this.base = base;
    }
    public int getBase() {
        return this.base;
    }
    public void setBase(int base) {
        this.base = base;
    }
}
