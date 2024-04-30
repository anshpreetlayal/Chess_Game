public abstract class Piece {
    private final PieceColor color;
    private Square currentPosition;
    private boolean isKilled = false;

    public Piece(PieceColor color, Square currentPosition) {
        this.color = color;
        this.currentPosition = currentPosition;
    }

    public abstract boolean isValidMove(Square destination);

    public PieceColor getColor() {
        return color;
    }

    public void setCurrentPosition(Square newPosition) {
        this.currentPosition = newPosition;
    }

    public Square getCurrentPosition() {
        return currentPosition;
    }

    public boolean isWhite() {
        return color == PieceColor.WHITE;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }


    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is occupied by own piece
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false; // Cannot capture own piece
        }

        // Check if the move is within the board boundaries
        if (!board.isValidSquare(end.getRow(), end.getCol())) {
            return false; // Invalid destination square
        }

        // Check if the piece has a valid path to the destination square (e.g., no obstacles)
        if (!isValidPath(board, start, end)) {
            return false; // Path is blocked
        }

        // Add specific logic for each piece type (e.g., Pawn, Knight, Bishop, Rook, Queen, King)
        return true; // Default implementation, override in subclasses
    }

    private boolean isValidPath(Board board, Square start, Square end) {
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();

        // Rook moves vertically or horizontally
        if (startRow == endRow) { // Horizontal move
            int minCol = Math.min(startCol, endCol);
            int maxCol = Math.max(startCol, endCol);
            for (int col = minCol + 1; col < maxCol; col++) {
                if (board.getSquare(startRow, col).getPiece() != null) {
                    return false; // Path is blocked
                }
            }
        } else if (startCol == endCol) { // Vertical move
            int minRow = Math.min(startRow, endRow);
            int maxRow = Math.max(startRow, endRow);
            for (int row = minRow + 1; row < maxRow; row++) {
                if (board.getSquare(row, startCol).getPiece() != null) {
                    return false; // Path is blocked
                }
            }
        } else {
            // Invalid move for a rook (shouldn't happen)
            return false;
        }

        return true; // Path is clear
    }

    public abstract String getSymbol();
}
