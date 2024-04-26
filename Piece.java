public abstract class Piece {
    private final boolean isWhite;
    private final String color;
    private Square currentPosition;
    private boolean isKilled = false;

    public Piece(String color, Square currentPosition) {
        this.color = color;
        this.isWhite = "white".equalsIgnoreCase(color); 
        this.currentPosition = currentPosition;
    }

    public abstract boolean isValidMove(Square destination);

    public String getColor() {

        return color;
    }

    public void setCurrentPosition(Square newPosition) {

        this.currentPosition = newPosition;
    }

    public Square getCurrentPosition() {

        return currentPosition;
    }

    public boolean isWhite() {

        return this.isWhite;
    }

    public boolean isKilled() {

        return this.isKilled;
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




    public boolean getSymbol() {

        return false;
    }

    public void setCurrentPosition(int row, int col) {
    }

    public void setCurrentPosition() {
    }
}
