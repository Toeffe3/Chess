package playchess;

abstract class Piece {

  boolean player;                                                     // true (white), false (black)
  int type;                                                           // 0-5, King Queen Bishop Knight Tower Pawn
  boolean alive = true;                                               // Is the piece alive??
  int[] pos = {0,0};                                                  // The pieces position

  Piece(char color, char t, x, y) {                                   // Creates the piece
  Piece(char color, char t, int x, int y) {                                   // Creates the piece
    player = color=='w'?true:false;                                   // Sets the player/color
    pos[0] = x; pos[1] = y;                                           // Set the position
    type = t=='k'?                                                    // Inline if else
      0
    :t=='q'?
      1
    :t=='b'?
      2
    :t=='n'?
      3
    :t=='t'?
      4
    :
      5;
  }

  abstract void moves(int x, int y);                                  // Allow to call the moves function which is differnt for all types
  abstract void move(int x, int y);                                   // -..
}
