public interface Damageable {
    //gets the total possible health of the damageable object
    public int getHealth();
    //takes damage from another object
    public int takeDmg(int dmg);
    //checks if the damageable object is dead
    public boolean isDead();
    //regenerates health for the object
    public int regenHealth();
    //gets the current health of the damageable object
    public int getCurrentHealth();

}
