public class King extends Piece {
    private boolean hasMoved = false;

    public King(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Board board, Spot start, Spot end) {
        // Implement the logic for Spot parameters if necessary
        return false; // Replace with actual logic
    }

    public boolean hasMoved() {
        return this.hasMoved;
    }

    public void markMoved() {
        this.hasMoved = true;
    }

}