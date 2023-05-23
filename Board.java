public class Board {

    private Cell[][] grid;

    public Board() {
        grid = new Cell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }

    private int[] getCoords(String pos) throws InvalidPositionException{
        int posx = 0;
        int posy = 0;

        if (pos.length() > 3 || pos.length() < 2) {
            throw new InvalidPositionException();
        }
        if (pos.length() == 3) {
            //System.out.println("AHAHA");
            //System.out.println(pos);
            //System.out.println(pos.substring(1,3));
            if (pos.substring(1,3).equals("10")) {
                posx = 9;
            }
            else {
                throw new InvalidPositionException();
            }
        }

        else {
            switch (pos.substring(1,2)) {
            case "1": posx = 0; break;
            case "2": posx = 1; break;
            case "3": posx = 2; break;
            case "4": posx = 3; break;
            case "5": posx = 4; break;
            case "6": posx = 5; break;
            case "7": posx = 6; break;
            case "8": posx = 7; break;
            case "9": posx = 8; break;
            default: throw new InvalidPositionException();
            }
            
        }

        switch (pos.substring(0,1).toLowerCase()) {
        case "a": posy = 0; break;
        case "b": posy = 1; break;
        case "c": posy = 2; break;
        case "d": posy = 3; break;
        case "e": posy = 4; break;
        case "f": posy = 5; break;
        case "g": posy = 6; break;
        case "h": posy = 7; break;
        case "i": posy = 8; break;
        case "j": posy = 9; break;
        default: throw new InvalidPositionException();
        }

        return new int[] {posx, posy};

    }

    public void placeShip(Ship ship, String pos, String dir) throws InvalidPlacementException, InvalidPositionException, InvalidShipTypeException {


        int posx = 0;
        int posy = 0;
        posx = getCoords(pos)[0];
        posy = getCoords(pos)[1];


        System.out.print(posx);
        System.out.println(posy);

        if (ship == null) {
            throw new InvalidShipTypeException();
        }

        switch (dir) {
            case "across":
                if (posx + ship.length() - 1 > 9) {
                    throw new InvalidPlacementException();
                }
                for (int i = 0; i < ship.length(); i++) {
                    if (grid[posy][posx + i].isOccupied()) {
                        System.out.println("FOOL");
                        throw new InvalidPlacementException();
                    }
                }
                break;
            
            case "down":
                if (posy + ship.length() - 1 > 9) {
                    throw new InvalidPlacementException();
                }
                for (int i = 0; i < ship.length(); i++) {
                    if (grid[posy + i][posx].isOccupied()) {
                        System.out.println("FOOL2");
                        throw new InvalidPlacementException();
                    }
                }
                break;

            default: throw new InvalidPlacementException();
        }


        switch (dir) {
            case "across":
                //System.out.println("haha2");
                for (int i = 0; i < ship.length(); i++) {
                    
                    //MUKUND THIS IS THE LINE FUCKING IT UP
                    //ITS BECAUSE ITS MAKING NEW SEGMENTS I THINK THEY SHOULD BE PART OF THE SAME SHIP
                    
                    grid[posy][posx + i].placeSegment(ship.getSegment(i+1));
                    //System.out.println(grid[posx + i][posy]);
                    //System.out.println();
                }

                break;
            
            case "down":

                for (int i = 0; i < ship.length(); i++) {
                    grid[posy + i][posx].placeSegment(ship.getSegment(i+1));
                }
                break;

            default: throw new InvalidPlacementException();
        }        
         
    }

    public void attack(String pos) throws InvalidPositionException{

        int posx = 0;
        int posy = 0;
        posx = getCoords(pos)[0];
        posy = getCoords(pos)[1];


        this.grid[posy][posx].attack();
    }

    public boolean hasBeenHit(String pos) throws InvalidPositionException {
        int posx = 0;
        int posy = 0;
        posx = getCoords(pos)[0];
        posy = getCoords(pos)[1];

        if (this.grid[posy][posx].hasBeenHit()) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        String output = ""; output+= " ";
        for (int i = 1; i < 11; i++) {
            output += " "; output += Integer.toString(i);
        }
        output += "\n"; char[] dic = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (int i = 0; i < 10; i++) {
            output += String.valueOf(dic[i]);
            for (int j = 0; j < 10; j++) {
                output += " "; output += grid[i][j].toString(); }
            output += "\n";
        }
        return output;
    }

    public String displaySetup() {
        String output = ""; output+= " ";
        for (int i = 1; i < 11; i++) {
            output += " "; output += Integer.toString(i); }
        output += "\n";
        char[] dic = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        for (int i = 0; i < 10; i++) {
            output += String.valueOf(dic[i]);
            for (int j = 0; j < 10; j++) {
                output += " "; output += grid[i][j].displaySetup();}
            output += "\n"; }
        return output;
    }
}

