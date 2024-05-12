public class Board {
    private final Square[][] squares;
    private final int numRows;
    private final int numCols;

    public Board(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
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
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }

    public void placePiece(Piece piece, int row, int col) {
        if (isValidPosition(row, col)) {
            Square square = squares[row][col];
            square.setPiece(piece);
            piece.setCurrentPosition();
        } else {
            System.out.println("Invalid position for placing piece.");
        }
    }

    public void removePiece(int row, int col) {
        if (isValidPosition(row, col)) {
            squares[row][col].setPiece(null);
        } else {
            System.out.println("Invalid position for removing piece.");
        }
    }

    public void displayBoard() {
        for (Square[] row : squares) {
            for (Square square : row) {
                Piece piece = square.getPiece();
                if (piece != null) {
                    System.out.print(piece.getColor().name().charAt(0) + " "); // Use enum value directly
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }


    public Square[][] getSquares() {
        return squares;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public boolean isValidSquare(int row, int col) {
        return row >= 0 && row < numRows && col >= 0 && col < numCols;
    }
}