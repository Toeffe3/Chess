package skak;

/**
 * Create tiles and helds all data for the current piece on the tile.
 * Can be assembled to a board.
 */
public class Tile {
    
    /**
     * Keeping all the piece data on the tile.
     */
    public Piece onTile;
    
    /**
     * Creates a tile for the board with or without a piece.
     * @param type the type 0-5
     * @param color the color of the piece 0: black, 1: white.
     */
    Tile(int type, int color) {
        switch (type) {
            case 4:
                onTile = new Rook(color);
                break;
            
            case 5:
                onTile = new Pawn(color);
                break;
            
            default:
                onTile = new empty();
                break;
        }
    }
}
