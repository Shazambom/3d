/**
* God I am so bored. I just made this location object for fun. Ugg this CSclass.
* Whatever, this class may be useful in the future. Probably for a game or
* three-dimensional spatial programming.
* @author Ian Moreno
* @version v1.0
*/
public class Location {
    private int xpos;
    private int ypos;
    private int zpos;
    /**
    * Constructs the Location object
    * @param xpos  the X Position of the location
    * @param ypos  the Y Position of the location
    * @param zpos  the Z position of the location
    */
    public Location(int xpos, int ypos, int zpos) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.zpos = zpos;
    }
    /**
    * Gets the X position of the Location object
    * @return xpos  the X Position of the location
    */
    public int getX() {
        return xpos;
    }
    /**
    * Gets the Y position of the Location object
    * @return ypos  the Y Position of the location
    */
    public int getY() {
        return ypos;
    }
    /**
    * Gets the Z position of the Location object
    * @return zpos  the Z Position of the location
    */
    public int getZ() {
        return zpos;
    }
    /**
    * Re-Constructs the Location object
    * @param xpos  the X Position of the location
    * @param ypos  the Y Position of the location
    * @param zpos  the Z position of the location
    */
    public void setLoc(int xpos, int ypos, int zpos) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.zpos = zpos;
    }
    /**
    * Sets the X value of the Location object to a value
    * @param xpos  the X Position of the location
    */
    public void setX(int xpos) {
        this.xpos = xpos;
    }
    /**
    * Sets the Y value of the Location object to a value
    * @param ypos  the Y Position of the location
    */
    public void setY(int ypos) {
        this.ypos = ypos;
    }
    /**
    * Sets the Z value of the Location object to a value
    * @param zpos  the Z Position of the location
    */
    public void setZ(int zpos) {
        this.zpos = zpos;
    }
    /**
    * Increases the X value of the Location object by one
    */
    public void movePosX() {
        xpos++;
    }
    /**
    * Increases the Y value of the Location object by one
    */
    public void movePosY() {
        ypos++;
    }
    /**
    * Increases the Z value of the Location object by one
    */
    public void movePosZ() {
        zpos++;
    }
    /**
    * Decreases the X value of the Location object by one
    */
    public void moveNegX() {
        xpos--;
    }
    /**
    * Decreases the Y value of the Location object by one
    */
    public void moveNegY() {
        ypos--;
    }
    /**
    * Decreases the Z value of the Location object by one
    */
    public void moveNegZ() {
        zpos--;
    }
    /**
    * Gets the distance between two points on the three dimensional plane
    * @param altX  X coordinate of other location
    * @param altY  Y coordinate of other location
    * @param altZ  Z coordinate of other location
    * @return distance-- the distance between the two locations
    */
    public double getDistance(Location alt) {
        return Math.sqrt(((xpos - alt.getX()) * (xpos - alt.getX()))
            + ((ypos - alt.getY()) * (ypos - alt.getY()))
            + ((zpos - alt.getZ()) * (zpos - alt.getZ())));
    }
    public Location deepCopy() {
        return new Location(this.xpos, this.ypos, this.zpos);
    }
}
