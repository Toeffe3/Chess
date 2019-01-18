public class Chess {

/*  Color: Code
 *  Reset: 0
 *  Sort:  1
 *  Rød:   2
 *  Grøn:  3
 *  Gul:   4
 *  Blå:   5
 *  Lilla: 6
 *  Cyan:  7
 *  Hvid:  8
 */

  public static String[][] onBoard = new String[8][8];
  public static String input = "";

  public static void main(String[] args) {

    //Scanner get = new Scanner(System.in());

    //Create all the pieces
    createBoard();

    // Greet message
    println("Welcome to Ches(e)s", 3,0);
    println("Use @help for help.",3,0);
    println();

    // print("♔♕♖♗♘♙ ", 8,0);    println(" K Q T B H P", 8,0);
    // print("♚♛♜ B♞♟ ", 0,0);    println(" k q t b h p", 0,0);

    //displayBoard();
  }

  /* Creates all the pices */
  static void createBoard() {

    //TODO: Create a array for all pieces
    King[]   wKings =   {new King(true)};
    Queen[]  wQueens =  new Queen[9];       //Making space for 1 + 8 pawn-queens
    Knight[] wKnights = {new Knight(true), new Knight(true)};
    Bishop[] wBishops = {new Bishop(true), new Bishop(true)};
    Rook[]   wRooks =   {new Rook(true), new Rook(true)};
    Pawn[]   wPawns =   new Pawn[8];

    wQueens[0] = new Queen(true);
    for (int i = 0; i < wPawns.length; i++) {
      wPawns[i] = new Pawn(true);
    }

    King[]   bKings =   {new King(false)};
    Queen[]  bQueens =  new Queen[9];       //Making space for 1 + 8 pawn-queens
    Knight[] bKnights = {new Knight(false), new Knight(false)};
    Bishop[] bBishops = {new Bishop(false), new Bishop(false)};
    Rook[]   bRooks =   {new Rook(false), new Rook(false)};
    Pawn[]   bPawns =   new Pawn[8];

    bQueens[0] = new Queen(false);
    for (int i = 0; i < bPawns.length; i++) {
      bPawns[i] = new Pawn(false);
    }

    // while (wKings[1].alive || bKings[1].alive) {
    //   // Continue game
    // }

  }

  static void displayBoard() {
    println();
    println("A B C D E F G H  x", 0,0);
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        if(onBoard[x][y]!=null) {
          print(" "+onBoard[x][y]+" ",0,1);
        } else if(y%2==x%2){
          print("  ",0,0);
        } else {
          print("  ",0,1);
        }
      }
      println(" "+(x+1),0,0);
    }
  }

  static void movepiece(int x, int y) {

  }


  /* Farst print and coloring */
  static void print(String text, int f, int b) {
    String y=(f+29)+"";
    if(f==0||f>8){y="0";}
    if(b>0&&b<9){y+=";"+(b+39);}
    print("\033["+y+"m"+text);
  } static void println(String text, int f, int b) {
    print(text+"\n",f,b);
  } static void print(String text) {
    System.out.print(text);
  } static void println(String text) {
    print(text+"\n");
  } static void print() {
    print("\033[0m");
  }  static void println() {
    println("\033[0m");
  }

}
