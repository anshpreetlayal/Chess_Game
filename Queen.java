public class Queen extends Piece{

    public Queen(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // Queen can move horizontally, vertically, or diagonally
        return rowDiff == 0 || colDiff == 0 || rowDiff == colDiff;
    }
    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is a valid move for the Queen
        if (!isValidMove(end)) {
            return false;
        }

        // Check if there are no pieces in the path of the Queen
        int rowDirection = Integer.compare(end.getRow(), start.getRow());
        int colDirection = Integer.compare(end.getCol(), start.getCol());

        int currentRow = start.getRow() + rowDirection;
        int currentCol = start.getCol() + colDirection;

        while (currentRow != end.getRow() || currentCol != end.getCol()) {
            if (board.getSquare(currentRow, currentCol).getPiece() != null) {
                // There is a piece in the path
                return false;
            }
            currentRow += rowDirection;
            currentCol += colDirection;
        }

        return true;
    }
}