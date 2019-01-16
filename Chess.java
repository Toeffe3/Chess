public class Chess {

  public static String[][] onBoard = new String[8][8];

  public static void main(String[] args) {
    createBoard();

    // System.out.println("Welcome to Ches(e)s");
    // System.out.println("♔♕♖♗♘♙");
    // System.out.println("♚♛♜ B♞♟");
    // System.out.println("■");
    // wKing.getPos();

    displayBoard();
  }

  //Creates all the pices
  static void createBoard() {
    King wKing = new King(true);
    Queen wQueen = new Queen(true);
    Knight wKnight1 = new Knight(true);
    Knight wKnight2 = new Knight(true);
    Bishop wBishop1 = new Bishop(true);
    Bishop wBishop2 = new Bishop(true);
    Rook wRook1 = new Rook(true);
    Rook wRook2 = new Rook(true);

    Pawn wPawn1 = new Pawn(true);
    Pawn wPawn2 = new Pawn(true);
    Pawn wPawn3 = new Pawn(true);
    Pawn wPawn4 = new Pawn(true);
    Pawn wPawn5 = new Pawn(true);
    Pawn wPawn6 = new Pawn(true);
    Pawn wPawn7 = new Pawn(true);
    Pawn wPawn8 = new Pawn(true);

    King bKing = new King(false);
    Queen bQueen = new Queen(false);
    Knight bKnight1 = new Knight(false);
    Knight bKnight2 = new Knight(false);
    Bishop bBishop1 = new Bishop(false);
    Bishop bBishop2 = new Bishop(false);
    Rook bRook1 = new Rook(false);
    Rook bRook2 = new Rook(false);

    Pawn bPawn1 = new Pawn(false);
    Pawn bPawn2 = new Pawn(false);
    Pawn bPawn3 = new Pawn(false);
    Pawn bPawn4 = new Pawn(false);
    Pawn bPawn5 = new Pawn(false);
    Pawn bPawn6 = new Pawn(false);
    Pawn bPawn7 = new Pawn(false);
    Pawn bPawn8 = new Pawn(false);
  }

  static void displayBoard() {
    System.out.println("A B C D E F G H  x");
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        if(onBoard[x][y]!=null) {
          System.out.print(onBoard[x][y]);
        } else if(y%2==x%2){
          System.out.print("■ ");
        } else {
          System.out.print("□ ");
        }
      }
      System.out.println(" "+x);
    }
  }
}
