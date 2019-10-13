package skak;

/**
* Workaround for creating public variables to be accesed anywhere.
*/
public class var {
    /**
     * The game-turn, specifies which players turn it is.
     */
    public static int turn = 0;
    
    /**
     * Keeps the entire board, and pieces within.
     */
    public static Tile[][] board = new Tile[8][8];
}
