public class King extends Piece {
    private boolean castlingDone = false;

    public King(String color, Square currentPosition) {

        super(color, currentPosition);
    }

    public boolean isCastlingDone() {

        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {

        this.castlingDone = castlingDone;
    }

    @Override
    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // King can move one square in any direction
        return rowDiff <= 1 && colDiff <= 1;
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is a valid move for the King
        if (!isValidMove(end)) {
            return false;
        }

        // Check if there are no pieces in the path of the King
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false; // Cannot capture a piece of the same color
        }

        // Additional logic for specific rules related to moving the King on the board
        // Implement as needed based on the specific rules of chess

        return true;
    }

    private boolean isValidCastling(Board board, Square start, Square end) {
        if (this.isCastlingDone()) {
            return false;
        }

        // Logic for determining if castling is valid
        // Implement based on the specific rules of chess

        // Example: Check if the rook is in the correct position, if there are no pieces
        // in the squares between the king and rook, and if the squares the king crosses
        // during castling are not under attack.

        return true; // Placeholder - replace with actual implementation
    }

    public boolean isCastlingMove(Square start, Square end) {
        // Check if the starting and ending position are correct for castling
        // Implement based on the specific rules of chess
        return false; // Placeholder - replace with actual implementation
    }
}
