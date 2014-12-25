public interface Levelable {
    /**
     *Levels up the entity in some way by increasing stats.
     *
     */
    public void levelUp();
    /**
     *Gets the entity's level.
     *@return The integer value of the entity's level.
     */
    public int getLevel();
}
