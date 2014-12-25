public class Tester {
    public static void main(String[] args) {
        try{
            Location[][][] alphaPlane = Plane.genPlane(10);
            Item weapon = new Item(new Location(0, 0, 0),
                "Dispair", 50, 10, 500, 500, 1000);
                Character shazambom = new Character(new Location(0, 0, 0),
                "Shazambom", 10, 10, 10, 10, weapon, 1);

            Item eWeapon = new Item(new Location(1, 1, 0),
                "Disdain", 5, 1, 5, 500, 1000);
                Character enemie = new Character(new Location(1, 1, 0),
                "Skelleton Guard", 10, 10, 10, 10, eWeapon, 1);

            System.out.println(enemie.getName() + " has "
                + enemie.getCurrentHealth() + " health");

            System.out.println(shazambom.getName() + " attacks " +
                enemie.getName() + " for " + shazambom.getDmg() + " dmg");


            enemie.takeDmg(shazambom.getDmg());
            System.out.println(enemie.getName() + " has "
                + enemie.getCurrentHealth() + " health");
                System.out.println("Is the target dead: " + enemie.isDead());
        } catch(EntityIsDeadException e){
            System.out.println(e.getMessage());
        }
    }
}
