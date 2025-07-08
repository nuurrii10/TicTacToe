public class Board {
    private char[][] cells;

    public Board() {
        this.cells = new char[3][3];
        this.clear();
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.cells[i][j] = ' ';
            }
        }
    }

    public boolean isCellEmpty(int x, int y) {
        if (this.cells[x][y] == ' ') {
            return true;
        }
        return false;
    }

    public void place(int x, int y, char marker) {

        if (isCellEmpty(x, y)) {
            this.cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (this.cells[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    public void print() {

    }

    public char[][] getCells() {
        char[][] result = new char[3][3];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = this.cells[i][j];
            }
        }
        return result;
    }


}





