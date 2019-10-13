package skak;

/**
 * All pieces functions.
 */

public class Piece {
    /**
     * The color of the piece black 0 / white 1
     */
    int farve;
    
    /**
     * The type of the piece 4: Rook, 5: Pawn, -1 none.
     */
    int type;
    
    /**
     * Creates a new piece
     * @param t type (0-5) for the different types og pieces
     * @param f color black/white 0/1
     **/
    Piece(int t, int f) {
        farve = f;
        type = t;
    }
    
    /**
     * Moves the piece if the move is valid
     * @param fx From x (the position of the piece)
     * @param fy From y (the position of the piece)
     * @param tx To x (the new position of the piece)
     * @param ty To y (the new position of the piece)
     * @return true if sucessfully moved or attacked 
     **/
    public boolean setPosition(int fx, int fy, int tx, int ty) {
        return false;
    }
    
    /**
     * Displays the piece as follows: [colorprefix]-[typeprefix] displays SPACEs if empty
     */
    public void display() {
        String[] nameOfType = {"K", "Q", "B", "N", "R", "P", " "};
        System.out.print(farve==1?"W-":farve==0?"B-":" -" );
        System.out.print(nameOfType[type>-1?type:6]+ " ");
    }
    
    /**
     * Replaces the piece on a new tile
     * @param fx From x (the position of the piece)
     * @param fy From y (the position of the piece)
     * @param tx To x (the new position of the piece)
     * @param ty To y (the new position of the piece)
     * @return true
     */
    boolean move(int fx, int fy, int tx, int ty) {
        var.board[tx][ty].onTile = this;
        var.board[fx][fy].onTile = new empty();
        return true;
    }
}
