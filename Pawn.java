public class Pawn extends Piece {

    public Pawn(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    @Override
    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());


        // Pawn can move forward by one square
        // or diagonally forward by one square to capture an opponent's piece
        if (getColor().equalsIgnoreCase("white")) {
            return (rowDiff == 1 && colDiff == 0) || (rowDiff == 1 && colDiff == 1);
        } else {
            return (rowDiff == -1 && colDiff == 0) || (rowDiff == -1 && colDiff == 1);
        }
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is a valid move for the Pawn
        if (!isValidMove(end)) {
            return false;
        }

        // Check if the destination square is occupied by a piece of the same color
        if (end.getPiece() != null && end.getPiece().isWhite() == isWhite()) {
            return false;
        }

        // Check if the pawn is moving forward by one square
        if (Math.abs(end.getRow() - start.getRow()) == 1 && Math.abs(end.getCol() - start.getCol()) == 0) {
            // Normal move: check if the destination square is empty
            return end.getPiece() == null;
        } else if (Math.abs(end.getRow() - start.getRow()) == 2 && Math.abs(end.getCol() - start.getCol()) == 0) {
            // Double-step on the first move
            if (isWhite() && start.getRow() == 6 && end.getRow() == 4) { // White pawn moving from row 6 to 4
                // Check if the squares in between are empty
                return board.getSquare(5, start.getCol()).getPiece() == null && end.getPiece() == null;
            } else if (!isWhite() && start.getRow() == 1 && end.getRow() == 3) { // Black pawn moving from row 1 to 3
                // Check if the squares in between are empty
                return board.getSquare(2, start.getCol()).getPiece() == null && end.getPiece() == null;
            }
        } else if (Math.abs(end.getRow() - start.getRow()) == 1 && Math.abs(end.getCol() - start.getCol()) == 1) {
            // Capturing diagonally
            if (end.getPiece() != null) {
                return true; // Can capture opponent's piece
            } else {
                // Implement based on the specific rules of en passant
            }
        }

        return false;
    }
}