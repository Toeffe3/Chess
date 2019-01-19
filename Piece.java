public class Piece {

  boolean player;   // true (white), false (black)
  int type;         // 0-5, King Queen Bishop Knight Tower Pawn
  boolean alive;
  int[] pos = {0,0};

  Piece(char color, char t) {
    player = color=='w'?true:false;
    type = t=='k'?
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
    alive = true;
  }

}
