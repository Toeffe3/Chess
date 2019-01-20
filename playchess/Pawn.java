package playchess;

class Pawn extends Piece {                                            // Extend from piece, allows all class pieces to be contained in same array

  boolean fistmove = true;

  Pawn(char color, int x, int y) {                                    // Creates a pawn
    super(color, 'p', x, y);                                          // Init as Piece
  }

  void move(int x, int y) {

    //onBoard[x][y]: where pieces are
    //selection[x][y][2] = valid moves to display
  }

  public void moves(int x, int y) {
    System.out.println("Hey");
    if(super.pos[0] == x && super.pos[1] == y) {

      /* Algo for valid movment */
      if (fistmove && var.onBoard[x+1][y] == '0' && var.onBoard[x+2][y] == '0') {
        System.out.print("Piece can move twice!");
      } else if(var.onBoard[x+1][y] == '0') {
        System.out.print("Piece can move");
      } else if (var.onBoard[x+1][y+1] != '0') {
        System.out.print("Piece can attack!");
      } else if (var.onBoard[x+1][y-1] != '0') {
        System.out.print("Piece can attack!");
      } else {
        System.out.print("Piece can't move");
      }
      //selection[x][y][2]
    }
  }

}
