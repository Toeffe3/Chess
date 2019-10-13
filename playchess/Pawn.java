package skak;

/**
 * For Creating a Pawn.
 */
public class Pawn extends Piece {
    /**
     * If the piece has moved once before
     */
    boolean fistmove = true;
    
    /**
     * Calls the master class with the color pram and pawn id (5).
     * @param color the color
     */
    Pawn(int f) {
        super(5,f);
    }
    
    /**
     * Validates the specific moves for a pawn
     * @return true if sucessfully moved or attacked
     */
    @Override
    public boolean setPosition(int fx, int fy, int tx, int ty) {
        try {
            int dir = var.board[fx][fy].onTile.farve==1?-1:1;
            if (fistmove && var.board[fx+dir][fy].onTile.farve == -1 && var.board[fx+dir+dir][fy].onTile.farve == -1 && fx+dir+dir==ty && fy==ty) {
                System.out.println("Piece moved twice!");
                fistmove = false;
                return move(fx, fy, tx, ty);
            } else if(var.board[fx+dir][fy].onTile.farve == -1 && fx+dir==tx && fy==ty) {
                System.out.println("Piece moved");
                fistmove = false;
                return move(fx, fy, tx, ty);
            } else if (var.board[fx+dir][fy+dir].onTile.farve != -1 && fx+dir==tx && fy+dir==ty) {
                System.out.println("Piece attacked!");
                fistmove = false;
                return move(fx, fy, tx, ty);
            } else if (var.board[fx+dir][fy-dir].onTile.farve != -1 && fx+dir==tx && fy-dir==ty) {
                System.out.println("Piece attacked!");
                fistmove = false;
                return move(fx, fy, tx, ty);
            }
        } catch (NullPointerException e) {
            var.board[fx][fy].onTile = this;
        }
        System.out.println("Piece didn't move!");
        var.turn--;
        return false;
    }
}
