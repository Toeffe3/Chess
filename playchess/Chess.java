package playchess;

import java.util.Scanner;

public class Chess {

  /*  Color codes
   *  Reset: 0
   *  Sort:  1
   *  Grøn:  3
   *  Gul:   4
   *  Blå:   5
   *  Lilla: 6
   *  Cyan:  7
   *  Hvid:  8
  */

  public static void main(String[] args) {

    Scanner get = new Scanner(System.in);                             // Init scanner
    createBoard();                                                    // Init board - Creates all the pieces

    print("",3,0);                                                    // Green font
    println("Welcome to Ches(e)s");                                   // Greet message
    println("Use @help for help.\n");                                 // -..

    // while (var.white[0].alive && var.black[0].alive) {
      // Continue game while both kings are alive

      displayBoard();                                                 // Show the board and all pieces
      var.input = get.next();                                         /*Capture the user input*/

      select(var.input);
      println("-> "+var.input,4,0);                                 /*For debugging purpose*/
      displayBoard();
      var.input = get.next();
    // }
  }

  static boolean fistselect = true;                                   // Keep track of wether to select a piece or move the piece

  static void select(String cord) {
    print("",2,0);                                                    // Set the text color to red (for errors)
    if (cord.matches("[A-H,a-h][1-8]")) {                             // Check that the input can be translated using Rexexp (Regular Expression)
      int px = 8-(cord.charAt(1)-48);                                 // Convert the cordinates to array-index
      int py = (int)cord.charAt(0)-(((int)cord.charAt(0)>=97)?97:65); // -..
      int sPiece = (int) var.onBoard[px][py];
      println("Seleted a "+(char)sPiece);
      if (sPiece<97&&var.turn%2==0||sPiece>=97&&var.turn%2==1) {      // Check if its the current players piece
        println("Ready for 2. selection");
        if (fistselect == true) {                                     // The fist selection
          fistselect = false;                                         // ready for second selection
          var.selection[px][py][0] = true;                            // Set the spot in selection array to true

          for(int i = 0; i < 16; i++) {                               // For all pieces
            var.white[i].moves(px,py);                                // Get valid moves for all white pieces at px,py
            var.black[i].moves(px,py);                                // -.. all black pieces
          }

        } else {                                                      // The second selection
          fistselect = true;                                          // -.. not
          var.selection[px][py][1] = true;                            // -.. where to move
        }
      }
    } else if(cord.matches("[A-H,a-h][1-8]")) {                       // Error messages
      print("Not a walid target.");                                   // -..
    } else if (cord.matches("[1-8][A-H,a-h]")) {                      // -..
      print("Invalid notation use X0 or x0.");                        // -..
    } else {                                                          // -..
      print("Invalid position, use A-H or a-h, and 1-8.");            // -..
    }
  }

  /* Creates all the pices */
  static void createBoard() {
    int x = 0;
    int y = 0;
    for (int i = 0; i < 32; i++) {
        char c = i<16?'w':'b';
        if(c=='w') {
          var.white[i]=i<1?new King(c,x,y)
          :i<2?
          new Queen(c,x,y)
          :i<4?
          new Bishop(c,x,y)
          :i<6?
          new Knight(c,x,y)
          :i<8?
          new Rook(c,x,y)
          :
          new Pawn(c,x,y);
        } else {
          var.black[i-16]=i<1?new King(c,x,y):i<2?new Queen(c,x,y):i<4?new Bishop(c,x,y):i<6?new Knight(c,x,y):i<8?new Rook(c,x,y):new Pawn(c,x,y);
        }
    }

    //TODO: Add the pos in the class instances! But how???
  }

  //TODO: Show valid paths for pieces
  static void displayBoard() {
    println();
    println("A B C D E F G H  x", 0,0);
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        if(var.onBoard[x][y]!='0') {
          int bclr = var.selection[x][y][0]?4:(y%2==x%2?1:8);
          int fclr = ((int)var.onBoard[x][y])>=97?6:7;
          print(""+var.onBoard[x][y]+" ",fclr,bclr);
        } else if(var.selection[x][y][0]){
          print("  ",0,4);
        } else {
          print("  ",0,(y%2==x%2?1:8));
        }
      }
      println(" "+(8-x),0,0);
    }
  }

  /* Farst print and coloring */
  public static void print(String text, int f, int b) {
    String y=(f+29)+"";
    if(f==0||f>8){y="0";}
    if(b>0&&b<9){y+=";"+(b+39);}
    print("\033["+y+"m"+text);
  } public static void println(String text, int f, int b) {
    print(text+"\n",f,b);
  } public static void print(String text) {
    System.out.print(text);
  } public static void println(String text) {
    print(text+"\n");
  } public static void print() {
    print("\033[0m");
  } public static void println() {
    println("\033[0m");
  }

}
