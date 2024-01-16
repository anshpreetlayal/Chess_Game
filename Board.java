public class Board {
    private Square[][] squares;

    public Board(int numRows, int numCols) {
        this.squares = new Square[numRows][numCols];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) {
                squares[row][col] = new Square(row, col, null);
            }
        }
    }

    public Square getSquare(int row, int col) {
        if (isValidPosition(row, col)) {
            return squares[row][col];
        } else {
            return null;
        }
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < squares.length && col >= 0 && col < squares[0].length;
    }

}
