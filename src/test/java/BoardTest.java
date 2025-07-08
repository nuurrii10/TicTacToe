import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {


    @Test
    void Test_clearPlacedMarker() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void Test_clearKeepsBoardEmpty() {
        Board board = new Board();
        board.clear();
        assertTrue(board.isCellEmpty(1, 1));
    }

    @Test
    void Test_isCellEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void Test_isCellEmpty_negative() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    void Test_place_checkIfMarkerSet() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertEquals('X', board.getCells()[1][1]);
    }

    @Test
    void Test_place_overwriteProtection() {
        Board board = new Board();
        board.place(1,1,'X');
        board.place(1,1,'O');
        assertEquals('X',board.getCells()[1][1]);
    }

    @Test
    void Test_isFull_positive() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void Test_isFull_negative() {
        Board board = new Board();
        for(int i = 0; i<2; i++){
            for(int j = 0; j<3;j++){
                board.place(i,j,'O');
            }
        }
        assertFalse(board.isFull());
    }

    @Test
    void  Test_print_ExpectedBoardFormat() {
        Board board = new Board();

        // Optional: Spielzug setzen, um Inhalt zu prüfen
        board.place(1, 1, 'X');

        // Standardausgabe umleiten
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        // Methode aufrufen
        board.print();

        // Wieder zurücksetzen
        System.setOut(originalOut);

        // Output holen
        String printed = output.toString();

        assertTrue(printed.contains("|X|"));
        assertTrue(printed.contains("_______"));
    }
}