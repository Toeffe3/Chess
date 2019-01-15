public class Pawn {

  boolean type;       //Black or white(true)
  boolean alive;      //It is alive
  boolean firstMove;  //Pawns can move twice the first time.
  int[] pos = {0,0};  //(A1) Its position [0] is the x-axis (letters) [1] is the y-axis (numbers)

  Pawn(boolean white) {
    type = white;
  }

  //Direction is a int 0-7. 0 is forward, 1 is diagonal right and so...
  //Amount is the amount to jump
  void move(int dir, int amo) {

  }

  void getPos() {
    char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    System.out.print(a[pos[0]] +""+ pos[1]);
  }

}
