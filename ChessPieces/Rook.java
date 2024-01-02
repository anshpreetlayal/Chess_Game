package ChessPieces;
public class Rook extends Piece {

    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Board board, GridBlock start, GridBlock end) {
        if (start == null || end == null) {
            return false;
        }

        int deltaX = Math.abs(start.getX() - end.getX());
        int deltaY = Math.abs(start.getY() - end.getY());

        // Rook can move either horizontally or vertically
        return (deltaX == 0 && deltaY > 0) || (deltaX > 0 && deltaY == 0);
    }
}
