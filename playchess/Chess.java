package skak;

/**
 * This program is a game of chess where there is one pawn and one rook for each player.
 * No futhure pieces have been implemented yet.
 * This is a school assignment in 2.digi Hansenberg
 * @author Emil
 * @auther Victor
 */

import java.util.Scanner;

/**
 * This is the main class.
 */
public class Chess {
    
    /**
     * Creates a board and pieces, then indefenly runs a while loop asking for players next move.
     */
    public static void main(String args[]) {
        
        for(int u = 0; u < 64; u++) { var.board[(int)(u/8)][u%8] = new Tile(-1,-1); }
        var.board[0][0] = new Tile(4,0);
        var.board[7][7] = new Tile(4,1);
        var.board[1][5] = new Tile(5,0);
        var.board[6][4] = new Tile(5,1);
        
        
        while(true) {
            System.out.print("#  A   B   C   D   E   F   G   H \n1 ");
            for(int u = 0; u < 64; u++) {
                var.board[(int)(u/8)][u%8].onTile.display();
                System.out.print((int)((u+1)/8)>(int)((u)/8)?"\n"+(u>56?"":(int)(u/8+2))+" ":"");
            }
            var.turn++;
            System.out.println("\nIt's is "+(var.turn%2>0?"white":"black")+" players turn ("+var.turn+")");
            getPlayerInput();
        }
    }
    
    static void getPlayerInput() {
        Scanner get = new Scanner(System.in);
        System.out.print("Select a piece: ");
        int[] selpos = cordToInt(get.next());
        if (selpos[0]!=-1) {
            
            String[] nameOfType = {"King", "Queen", "Bishop", "Knight", "Rook", "Pawn", "none"};
            System.out.println("Selected: "+selpos[0]+", "+selpos[1]+" - "+nameOfType[var.board[selpos[0]][selpos[1]].onTile.type==-1?6:var.board[selpos[0]][selpos[1]].onTile.type]);
            
            if(var.board[selpos[0]][selpos[1]].onTile.farve == (var.turn%2>0?1:0)) {
                System.out.print("Choose a new position: ");
                int[] targetpos = cordToInt(get.next());
                if (targetpos[0]==-1) { System.out.println("Out of board!"); var.turn--; } else {
                    var.board[selpos[0]][selpos[1]].onTile.setPosition(selpos[0], selpos[1], targetpos[0], targetpos[1]);
                }
            } else { System.out.println("Not a/your piece!"); var.turn--; }
        } else { System.out.println("Out of board!"); var.turn--;}
    }
    
    static int[] cordToInt(String cord) {
        if (cord.matches("[A-H,a-h][1-8]")) {
            return new int[]{ (cord.charAt(1)-49), (int)cord.charAt(0)-(((int)cord.charAt(0)>=97)?97:65) };
        }
        return new int[]{-1,-1};
    }
}
