public class Enemy extends Entity {
    private boolean isAlive;
    public Enemy(Location loc, String name, int str, int intel,
        int dex, int health) {
        super(loc, name, str, intel, dex, health);
        isAlive = true;
    }
    /**
     *Called when an enemy attacks a player and does dammage to the player.
     *
     *@throws EntityIsDeadException an Exception that indicates the Enemy is
     *dead and therefore cannot attack. This Exception should be handeled by
     *destroying the enemy object.
     */
    public void attackPlayer(Character player) throws EntityIsDeadException{
        if (isAlive) {
            player.takeDmg(this.getDmg());
        } else {
            throw new EntityIsDeadException("I'm Dead! I can't Attack");
        }

    }
    public int getDmg() {
        return super.getStr() + super.getIntel() + super.getDex();
    }
    /**
     *Allows an enemy to take damage. If the hit kills the enemey it returns
     *true to indicate death.
     *@param dmg The dammage amount being dealt to the enemy.
     *@return True if dead false if Ailve
     */
    public boolean takeDmg(int dmg) {
        super.setHealth(super.getHealth() - dmg);
        if (super.getHealth() < 0) {
            isAlive = false;
            return true;
        }
        return false;
    }
    /**
     *Returns a boolean value to check whether or not the enemy is alive or dead
     *@return Is True if alive, false if dead
     */
    public boolean getState() {
        return isAlive;
    }
}
