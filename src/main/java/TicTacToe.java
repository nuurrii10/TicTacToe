import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        Scanner sc = new Scanner(System.in);

        while (!board.isFull()) {
            while (true) {
                board.print();
                System.out.println("Current Player:  " + currentPlayer.getMarker());
                int x = -1;
                while (x < 0 || x > 2) {
                    System.out.println("Set row (1-3): ");
                    x = sc.nextInt() - 1;
                }
                int y = -1;
                while (y < 0 || y > 2) {
                    System.out.println("Set column (1-3): ");
                    y = sc.nextInt() - 1;
                }
                if (board.isCellEmpty(x, y)) {
                    board.place(x, y, currentPlayer.getMarker());
                    switchCurrentPlayer();
                    break;
                } else {
                    System.out.println("Position taken. Please choose an empty field.");
                }
            }
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;

    }

    private boolean hasWinner() {
        return false;
    }
}




