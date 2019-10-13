package skak;

/**
 * For Creating a Rook.
 */
public class Rook extends Piece {
    
    /**
     * Calls the master class with the color pram and rooks id (4).
     * @param color the color
     */
    Rook(int color) {
        super(4,color);
    }
    
    /**
     * Validates the specific moves for a pawn.
     * @return true if sucessfully moved or attacked
     */
    @Override
    public boolean setPosition(int fx, int fy, int tx, int ty) {

        boolean allowMove = false;
        if(fx==tx || fy==ty) {
            if(fx == tx) {
                for(int u = fy+1; u < 8; u++) {
                    if(var.board[fx][u].onTile.farve==-1) {allowMove = true; } else { break; }
                }
                
                for(int u = fy-1; u > 0; u--) {
                    if(var.board[fx][u].onTile.farve==-1) {allowMove = true; } else { break; }
                }
            }
            
            if(fy == ty) {
                for(int u = fx+1; u < 8; u++) {
                    if(var.board[u][fy].onTile.farve==-1) {allowMove = true; } else { break; }
                }
                
                for(int u = fx-1; u > 0; u--) {
                    if(var.board[u][fy].onTile.farve==-1) {allowMove = true; } else { break; }
                }
            }
            
        }
        if (allowMove) return move(fx,fy,tx,ty); else {
            var.turn--;
        } return false;
    }
}
