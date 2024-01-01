public class King extends Piece {
    private boolean hasMoved = false;

    public King(boolean isWhite) {
        super(isWhite);
    }

    public boolean hasMoved() {
        return this.hasMoved;
    }

    public void markMoved() {
        this.hasMoved = true;
    }

    @Override
    public boolean isValidMove(Board board, GridBlock start, GridBlock end) {
        if (!super.isValidMove(board, start, end)) {
            return false;
        }

        int deltaX = Math.abs(start.getX() - end.getX());
        int deltaY = Math.abs(start.getY() - end.getY());

        // King can move one square in any direction
        return (deltaX <= 1 && deltaY <= 1);
    }
}