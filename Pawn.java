public class Pawn extends Piece {
    private boolean hasMoved = false;

    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Board board, GridBlock start, GridBlock end) {
        if (start == null || end == null) {
            return false;
        }

        int deltaX = end.getX() - start.getX();
        int deltaY = Math.abs(end.getY() - start.getY());

        // Pawn's movement logic (general forward move, capture diagonally)
        if (this.isWhite()) {
            return deltaX == -1 && deltaY == 0;
        } else {
            return deltaX == 1 && deltaY == 0;
        }
    }
}
