import java.util.Scanner;
import java.lang.NullPointerException;

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

  public static String[][] onBoard = new String[8][8];                // 2D array with all current pieces

  static Piece[] white = new Piece[16];                               // Array for all white pieces
  static Piece[] black = new Piece[16];                               // -..

  public static String input = "";                                    //

  public static void main(String[] args) {

    Scanner get = new Scanner(System.in);

    //Create all the pieces
    createBoard();



    // Greet message
    println("Welcome to Ches(e)s", 3,0);
    println("Use @help for help.",3,0);
    println();

    //while (white[0].alive && black[0].alive) {
      // Continue game while both kings are alive

      input = get.next();
      print(input);

    //}

    // print("♔♕♖♗♘♙ ", 8,0);    println(" K Q T B H P", 8,0);
    // print("♚♛♜ B♞♟ ", 0,0);    println(" k q t b h p", 0,0);

    displayBoard();
  }

  /* Creates all the pices */
  static void createBoard() {
    for (int i = 0; i < 32; i++) {
        char c = i<16?'w':'b';
        white[i%16]=i<1?
          new King(c)
        :i<2?
          new Queen(c)
        :i<4?
          new Bishop(c)
        :i<6?
          new Knight(c)
        :i<8?
          new Rook(c)
        :
          new Pawn(c);
    }
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
      println(" "+(7-x+1),0,0);
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
