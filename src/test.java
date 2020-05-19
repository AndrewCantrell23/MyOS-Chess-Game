import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Board board = new Board();

        Scanner input = new Scanner(System.in);

        while(!board.isGameOver()){
            if(board == null){
                throw new IllegalStateException("That's Illegal");
            }
            board.displayBoard();

            String original = input.next();
            String next = input.next();
            char a = original.charAt(0);
            int currx = Integer.parseInt(original.substring(1));
            char b = next.charAt(0);
            int nextx = Integer.parseInt(next.substring(1));
            board.move(a, currx, b, nextx);
        }
        board.displayBoard();
        System.out.println("Game is over!");
    }
}
