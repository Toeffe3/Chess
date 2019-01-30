package playchess;

public class var {
  public static char[][] onBoard = {                                  // 2D array with all current pieces
    {'r','n','b','q','k','b','n','r'},
    {'p','p','p','p','p','p','p','p'},
    {'0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0'},
    {'0','0','0','0','0','0','0','0'},
    {'P','P','P','P','P','P','P','P'},
    {'R','N','B','Q','K','B','N','R'},
  };

  public static boolean[][][] selection = new boolean[8][8][3];       // 3 layered 2D array for keeping track of the two selections (pick, move)

  static Piece[] white = new Piece[16];                               // Array for all white pieces
  static Piece[] black = new Piece[16];                               // -.. black pieces

  public static int turn = 0;                                         // Keep track of player turn (white is equal)
  public static String input = "";                                    // For user input
}
