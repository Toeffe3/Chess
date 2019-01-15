public class Chess {

  //Create tow kings
  static King wKing = new King(true);
  static King bKing = new King(false);

  public static void main(String[] args) {
    System.out.println("Welcome to Ches(e)s");
    wKing.getPos();
  }
}
