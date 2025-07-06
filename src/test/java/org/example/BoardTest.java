package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    public void testPlaceValid() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertEquals('X', board.getCell(1, 1));
    }

    @Test
    public void testPlaceOnOccupied() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 0, 'O'); // sollte ignoriert werden
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    public void testIsCellEmptyTrue() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    public void testIsCellEmptyFalse() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

}
