package playchess;

public class Bishop extends Piece {

  Bishop(char color, int x, int y) {
    super(color, 'b', x, y);
  }

  void move(int x, int y) {

    //onBoard[x][y]: where pieces are
    //selection[x][y][2] = valid moves to display
  }

  public void moves(int x, int y) {
    if(super.pos[0] == x && super.pos[1] == y) {
      System.out.println("Found a piece at: "+x+","+y);

      int mvs[] = {0,0,0,0};
      for(mvs[0]; mvs[0] < 8; mvs[0]++){
        if (var.onBoard[x+mvs[0]][y+mvs[0]] == '0'){
          selection[x-mvs[0]][y+mvs[0]][1]=true;
        } else {
          break;
        }
        for(mvs[0]; mvs[0] < 8; mvs[0]++){
          if (var.onBoard[x+mvs[0]][y-mvs[0]] == '0'){
            selection[x-mvs[0]][y-mvs[0]][1]=true;
          } else {
            break;
          }
        }
        for(mvs[0]; mvs[0] < 8; mvs[0]++){
          if (var.onBoard[x-mvs[0]][y+mvs[0]] == '0'){
            selection[x-mvs[0]][y+mvs[0]][1]=true;
          } else {
            break;
          }
        }
        for(mvs[0]; mvs[0] < 8; mvs[0]++){
          if (var.onBoard[x-mvs[0]][y-mvs[0]] == '0'){
            selection[x-mvs[0]][y-mvs[0]][1]=true;
          } else {
            break;
          }
        }
      }
    }
  }
}
