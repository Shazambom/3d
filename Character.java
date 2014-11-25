/* This is the Character class.... LOOK AT IT
 * It is basically the main character but it can also be enemies too
 * Enemies should have lower stats... I guess I shouldn't have so many
 * magic numbers in here. I'll change that ~ aaaand changed.
 */
public class Character extends Entity implements Damageable, Aggroable{
    private Item weapon;
    private int level;
    private int exp;
    private int vit;
    private int regen;
    public Character(Location loc, String name, int str, int intel,
        int dex, int health, Item weapon, int regen) {
        super(loc, name, str, intel, dex, health);
        this.weapon = weapon;
        this.regen = regen;
        this.level = 1;
        this.exp = 0;
        this.vit = super.getHealth();
        if (this.weapon != null) {
            this.vit = vit * this.weapon.getHealth();
        }

    }
    public int getDmg() {
        int dmg = 0;
        int base = 0;
        int wIntel = super.getIntel();
        int wDex = super.getDex();
        int wStr = super.getStr();
        if (this.weapon != null) {
            wStr += this.weapon.getBase();
            wDex += this.weapon.getDex();
            wIntel += this.weapon.getIntel();
        }
        base += wStr;
        dmg += base * wDex;
        dmg += base * wIntel * wIntel;
        return dmg;
    }
    //These stats may get out of had quickly if levels are too high
    public void levelUp() {
        this.level++;
        super.setIntel(power(super.getIntel(), this.level));
        super.setDex(power(super.getDex(), this.level));
        super.setStr(power(super.getStr(), this.level));
        super.setHealth(power(super.getHealth(), this.level));
        this.regen += this.level;
    }
    public int getLevel() {
        return this.level;
    }
    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }
    public Item getWeapon() {
        return this.weapon;
    }
    /* Don't worry about this, its voodoo magic
     * Jk its just the Math.pow(a,b) function.
     * I made it because its just faster and because the Math.pow(a,b)
     * is slow
     */
    public static int power(int base, int power) {
        int val = base;
        for (int i = 1; i < power; i++) {
            val = val * base;
        }
        return val;
    }
    public int getExp() {
        return this.exp;
    }
    public void gainExp(int exp) {
        this.exp += exp;
    }
    public int getCurrentHealth() {
        return vit;
    }
    public boolean isDead() {
        if (this.vit <= 0) {
            return true;
        } else {
            return false;
        }
    }
    public int takeDmg(int dmg) {
        int finDmg = dmg/power((super.getStr() + weapon.getStr()), 2);
        finDmg = finDmg/(super.getDex() + weapon.getDex());
        vit -= finDmg;
        System.out.println(super.getName() + " took " + finDmg + " damage");
        return finDmg;
    }
    public int regenHealth() {
        if (this.vit < super.getHealth()) {
            this.vit += this.regen;
            return this.regen;
        }
        this.vit = super.getHealth();
        return 0;
    }
}
