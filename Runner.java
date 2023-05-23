public class Runner {
    public static void main(String[] args) {

        try {
        //Create and run things, print stuff out, etc.
        Board a = new Board();
        //Ship p = Ship.createShip("patrol boat");
        Ship sub = Ship.createShip("submarine");
        //System.out.println("lol");
        a.placeShip(sub, "g2", "across");
        System.out.println(a.displaySetup());
        //a.attack("a10");
        //System.out.println("lol2");
        //a.placeShip(p, "a1", "across");
        a.attack("g5");
        a.attack("g4");
        System.out.println(a);
        a.attack("g3");
        a.attack("g2");
        System.out.println(a.hasBeenHit("b3"));
        a.attack("b3");
        System.out.println(a.hasBeenHit("b3"));
        System.out.println(a);
    
        }

        catch (InvalidPlacementException e) {
            System.out.println("inval placement main");
        }
        catch (InvalidShipTypeException e) {
            System.out.println("A");
        }
        catch (InvalidPositionException e) {
            System.out.println("inval pos exception main");
        }
    }
}
