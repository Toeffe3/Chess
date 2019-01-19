import java.util.Scanner;

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

  public static char[][] onBoard = {
    {'r','n','b','q','k','b','n','r'},
    {'p','p','p','p','p','p','p','p'},
    {'0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0'},
    {'P','P','P','P','P','P','P','P'},
    {'R','N','B','Q','K','B','N','R'},
  };                                                                  // 2D array with all current pieces
  public static boolean[][][] selection = new boolean[8][8][2];       // 2layered 2D array for keeping track of the two selections (pick, move)

  static Piece[] white = new Piece[16];                               // Array for all white pieces
  static Piece[] black = new Piece[16];                               // -.. black pieces

  public static int turn = 0;                                         // Keep track of player turn (white is equal)
  public static String input = "";                                    // For user input

  public static void main(String[] args) {

    Scanner get = new Scanner(System.in);                             // Init scanner
    createBoard();                                                    // Init board - Creates all the pieces

    // Greet message
    print("",3,0); // Green font
    println("Welcome to Ches(e)s");
    println("Use @help for help.\n");

    //while (white[0].alive && black[0].alive) {
      // Continue game while both kings are alive

      displayBoard();                                                 // Show the board and all pieces
      input = "d2";                                                   /*Capture the user input*/
          println("-> "+input,4,0);                                       /*For debugging purpose*/
      select(input); //select(get.next());                            // Capture the user input

    //}
  }

  static boolean fistselect = true;                                   // Keep track of wether to select a piece or move the piece

  static void select(String cord) {
    print("",2,0);                                                    // Set the text color to red (for errors)
    if (cord.matches("[A-H,a-h][1-8]")) {                             // Check that the input can be translated using Rexexp (Regular Expression)
      int px = 8-(cord.charAt(1)-48);                                 // Convert the cordinates to array-index
      int py = (int)cord.charAt(0)-(((int)cord.charAt(0)>=97)?97:65); // -..
      int sPiece = (int) onBoard[px][py];
      if (sPiece<97 && turn%2==0 || sPiece>=97 && turn%2==1) {        // Check if its the current players piece
        if (fistselect == true) {                                     // The fist selection
          fistselect = false;                                         // ready for second selection
          selection[px][py][0] = true;                                // Set the spot in selection array to true
        } else {                                                      // The second selection
          fistselect = true;                                          // -.. not
          selection[px][py][1] = true;                                // -.. where to move
        }
      }
    } else if(cord.matches("[A-H,a-h][1-8]")) {                       // Error messages
      print("Not a walid target.");                                   // -..
    } else if (cord.matches("[1-8][A-H,a-h]")) {                      // -..
      print("Invalid notation use X0 or x0.");                        // -..
    } else {
      print("Invalid position, use A-H or a-h, and 1-8.");            // -..
    }
  }

  /* Creates all the pices */
  static void createBoard() {
    for (int i = 0; i < 32; i++) {
        char c = i<16?'w':'b';
        if(c=='w') {
          white[i]=i<1?new King(c):i<2?new Queen(c):i<4?new Bishop(c):i<6?new Knight(c):i<8?new Rook(c):new Pawn(c);
        } else {
          black[i-16]=i<1?new King(c):i<2?new Queen(c):i<4?new Bishop(c):i<6?new Knight(c):i<8?new Rook(c):new Pawn(c);
        }
    }

    //TODO: Add the pos in the class instances! But how???
  }

  //TODO: Add valid paths for selected piece
  static void displayBoard() {
    println();
    println("A B C D E F G H  x", 0,0);
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        if(onBoard[x][y]!='0') {
          int bclr = (y%2==x%2?1:8);
          int fclr = ((int)onBoard[x][y])>=97?6:7;
          print(""+onBoard[x][y]+" ",fclr,bclr);
        } else if(selection[x][y][0]){
          print("  ",0,4);
        } else {
          print("  ",0,(y%2==x%2?1:8));
        }
      }
      println(" "+(8-x),0,0);
    }
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
  } static void println() {
    println("\033[0m");
  }

}
