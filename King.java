public class King {

  boolean type;       //Black or white(true)
  boolean alive;      //It is alive
  int[] pos = {0,0};  //Its position [0] is the y-axis [1] is the x (Letters)

  King(boolean white) {

  }

  //Direction is a int 0-7. 0 is forward, 1 is diagonal right and so...
  //Amount is the amount to jump
  void move(int dir, int amo) {

  }

  void getPos() {
    char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
    System.out.print(pos[0] +""+ a[pos[1]]);
  }

}
