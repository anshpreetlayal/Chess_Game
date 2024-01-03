public class Bishop extends Piece {

    public Bishop(boolean isWhite) {
        super();
    }

    @Override
    public boolean isValidMove(Board board, Spot start, Spot end) {
        return false;
    }

    @Override
    public boolean isValidMove(Board board, GridBlock start, GridBlock end) {
        if (start == null || end == null) {
            return false;
        }

        int deltaX = Math.abs(start.getX() - end.getX());
        int deltaY = Math.abs(start.getY() - end.getY());

        // Bishop can move diagonally (equal deltaX and deltaY)
        return deltaX == deltaY;
    }
}
