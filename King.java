public class King extends Piece {
    private boolean castlingDone = false;

    public King(String isWhite) {
        super(isWhite);
    }

    public boolean isCastlingDone() {
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone) {
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean isValidMove(Square destination) {
        return false;
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // We can't move the piece to a square that
        // has a piece of the same color
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int rowDiff = Math.abs(start.getRow() - end.getRow());
        int colDiff = Math.abs(start.getCol() - end.getCol());

        if (rowDiff + colDiff == 1) {
            // Check if this move will not result in the king
            // being attacked, if so, return true
            return true;
        }

        return isValidCastling(board, start, end);
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

        return true;
    }

    public boolean isCastlingMove(Square start, Square end) {

        return false;
    }
}
