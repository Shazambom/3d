public class Mage extends Enemy {
    public Mage(Location loc, String name, int str, int intel,
        int dex, int health) {
        super(loc, name, str, intel, dex, health);
    }
    @Override
    public int getDmg() {
        return super.getInt() * super.getDex();
    }
}
