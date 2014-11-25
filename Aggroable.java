public interface Aggroable {
    //calculates the damage this object can inflict
    public int getDmg();
    //increases the level var of the object which directly affects dmg
    public void levelUp();
    //returns the level var of the object
    public int getLevel();
    //gives the object a weapon that affects dmg
    public void setWeapon(Item weapon);
    //returns the Item object that this object is holding
    public Item getWeapon();
    //gets the amount of EXP this object has created
    public int getExp();
    //increases the EXP of this object
    public void gainExp(int exp);
}
