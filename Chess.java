public class Chess {

  static final String RESET    = "\033[0m";   //Nulstil
  final String BLACK    = "\033[30m";
  final String RED      = "\033[31m";
  final String GREEN    = "\033[32m";
  final String YELLOW   = "\033[33m";
  final String BLUE     = "\033[34m";
  final String PURPLE   = "\033[35m";
  final String CYAN     = "\033[36m";
  final String WHITE    = "\033[37m";
  final String bBLACK   = "\033[40m";  //Virker ikke i Netbeans
  final String bRED     = "\033[41m";
  final String bGREEN   = "\033[42m";
  final String bYELLOW  = "\033[43m";
  final String bBLUE    = "\033[44m";
  final String bPURPLE  = "\033[45m";
  final String bCYAN    = "\033[46m";
  final String bWHITE   = "\033[47m";

  public static String[][] onBoard = new String[8][8];

  public static void main(String[] args) {
    createBoard();

    System.out.println("Welcome to Ches(e)s");

    System.out.print(c.BLACK+""+c.bWHITE);
    System.out.println("♔♕♖♗♘♙");

    System.out.println(c.WHITE+""+c.bBLACK);
    System.out.println("♔♕♖♗♘♙");

    Print("#",8,1);
    // System.out.println("K Q T B H P");
    // System.out.println("♚♛♜ B♞♟");
    // System.out.println("k q t b h p{}");
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

    while (wKing.alive || bKing.alive) {

    }

  }

  static void displayBoard() {
    System.out.println("\033[33mA B C D E F G H  x");
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        if(onBoard[x][y]!=null) {
          System.out.print(onBoard[x][y]);
        } else if(y%2==x%2){
          System.out.print("\033[37m■ ");
        } else {
          System.out.print("\033[30m■ ");
        }
      }
      System.out.println("\033[33m "+(x+1));
    }
  }
}

public void Print(String text, int f, int b) {
  String y=(f+29)+"";
  if(f==0||f>8){y="0";}
  if(b>0&&b<9){y+=";"+(b+39);}
  System.out.print("\033["+y+"m"+text);
} public void Print() {
    System.out.print(RESET);
}
