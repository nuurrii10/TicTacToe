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
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            board.clear();
            currentPlayer = player1;

            while (!hasWinner() && !board.isFull()) {
                board.print();
                System.out.println("Current Player: " + currentPlayer.getMarker());

                int x = -1, y = -1;

                // Zeile eingeben
                while (x < 0 || x > 2) {
                    System.out.print("Set row (1-3): ");
                    if (sc.hasNextInt()) {
                        x = sc.nextInt() - 1;
                    } else {
                        sc.next(); // ungültige Eingabe überspringen
                        x = -1;
                    }
                }

                // Spalte eingeben
                while (y < 0 || y > 2) {
                    System.out.print("Set column (1-3): ");
                    if (sc.hasNextInt()) {
                        y = sc.nextInt() - 1;
                    } else {
                        sc.next(); // ungültige Eingabe überspringen
                        y = -1;
                    }
                }

                // Feld belegen
                if (board.isCellEmpty(x, y)) {
                    board.place(x, y, currentPlayer.getMarker());

                    // Überprüfen ob aktueller Spieler gewonnen hat
                    if (hasWinner()) {
                        board.print();
                        System.out.println("Game won by Player " + currentPlayer.getMarker() + "!");
                        break;
                    }

                    // Nur Spieler wechseln, wenn kein Sieger
                    switchCurrentPlayer();
                } else {
                    System.out.println("Position taken. Please choose an empty field.");
                }
            }

            // Unentschieden prüfen
            if (board.isFull() && !hasWinner()) {
                board.print();
                System.out.println("Draw!");
            }

            // Nochmal spielen?
            System.out.print("Play again? (y/n): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        sc.close();
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




