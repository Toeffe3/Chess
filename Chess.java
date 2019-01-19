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

  public static String[][] onBoard = new String[8][8];                // 2D array with all current pieces
  public static boolean[][][] selection = new boolean[8][8][2];       // 2layered 2D array for keeping track of the two selections (pick, move)

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

      input = "D4"; //get.next();
      select(input);

    //}

    // print("♔♕♖♗♘♙ ", 8,0);    println(" K Q T B H P", 8,0);
    // print("♚♛♜ B♞♟ ", 0,0);    println(" k q t b h p", 0,0);

    displayBoard();
  }

  static boolean fistselect;

  static void select(String cord) {

    if (cord.matches("[A-H,a-h][1-8]")) {
      println("Sucess");
      if (fistselect == true) {

      } else {
        fistselect = true;
        selection[8-(cord.charAt(1)-48)][(int)cord.charAt(0)-(((int)cord.charAt(0)>=97)?97:65)][0] = true;
        fistselect = false;
      }

    } else if (cord.matches("[1-8][A-H,a-h]")) {
      print("Invalid notation use X0 or x0.", 2,0);
    } else {
      print("Invalid position, use A-H or a-h and 1-8.", 2,0);
    }
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
          int bclr = onBoard[x][y].matches("[k,q,b,n,t]")?8:1;
          int fclr = onBoard[x][y].matches("[k,q,b,n,t]")?1:0;
          print(" "+onBoard[x][y]+" ",fclr,bclr);
        } else if(selection[x][y][0]){
          print("",0,4);
        } else {
          print("",0,(y%2==x%2?0:1));
        }
        print("  ");
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
