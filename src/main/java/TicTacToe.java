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

        while (!hasWinner() && !board.isFull()) {
            board.print();
            while (!board.isFull()) {
                while (true) {
                    System.out.println("Current Player:  " + currentPlayer.getMarker());
                    int x = -1, y = -1;
                    while (x < 0 || x > 2) {
                        System.out.println("Set row (1-3): ");
                        x = sc.nextInt() - 1;
                    }
                    while (y < 0 || y > 2) {
                        System.out.println("Set column (1-3): ");
                        y = sc.nextInt() - 1;
                    }
                    if (board.isCellEmpty(x, y)) {
                        board.place(x, y, currentPlayer.getMarker());
                        if (hasWinner()) {
                            board.print();
                            System.out.println("Game won by Player " + currentPlayer.getMarker());
                            return;
                        }
                        switchCurrentPlayer();
                        break;
                    } else {
                        System.out.println("Position taken. Please choose an empty field.");
                    }
                }
                board.print();
                if(board.isFull() && !hasWinner()) {
                    System.out.println("Draw!");
                }
            }
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;

    }

    private boolean hasWinner() {
        char marker = currentPlayer.getMarker();
        char[][] cells = board.getCells();

        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker) {
                return true;
            }
        }

        if (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) {
            return true;
        }

        if (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker) {
            return true;
        }

        return false;
    }
}




