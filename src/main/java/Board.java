public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public boolean isCellEmpty(int x, int y) {
        if (cells[x][y] == ' ') {
            return true;
        }
        return false;
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public void print() {

    }


}





