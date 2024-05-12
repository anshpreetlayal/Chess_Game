public class Rook extends Piece {

    public Rook(String color, Square currentPosition) {
        super(PieceColor.valueOf(color), currentPosition);
    }

    @Override
    public boolean isValidMove(Square destination) {
        // A rook can move either horizontally or vertically
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        return (rowDiff == 0 && colDiff > 0) || (rowDiff > 0 && colDiff == 0);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is a valid move for the Rook
        if (!isValidMove(end)) {
            return false;
        }

        // Check if there are no pieces in the path of the Rook
        if (end.getRow() == start.getRow()) {
            // Moving horizontally
            int colDirection = Integer.compare(end.getCol(), start.getCol());
            int currentCol = start.getCol() + colDirection;

            while (currentCol != end.getCol()) {
                if (board.getSquare(start.getRow(), currentCol).getPiece() != null) {
                    // There is a piece in the path
                    return false;
                }
                currentCol += colDirection;
            }
        } else if (end.getCol() == start.getCol()) {
            // Moving vertically
            int rowDirection = Integer.compare(end.getRow(), start.getRow());
            int currentRow = start.getRow() + rowDirection;

            while (currentRow != end.getRow()) {
                if (board.getSquare(currentRow, start.getCol()).getPiece() != null) {
                    // There is a piece in the path
                    return false;
                }
                currentRow += rowDirection;
            }
        } else {
            // Invalid move (neither horizontal nor vertical)
            return false;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return null;
    }

}