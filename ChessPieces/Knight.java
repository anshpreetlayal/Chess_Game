package ChessPieces;
public class Knight extends Piece {

    public Knight(boolean isWhite) {
        super(isWhite);
    }
    @Override
    public boolean isValidMove(Board board, GridBlock start, GridBlock end) {
        if (start == null || end == null) {
            return false;
        }

        int deltaX = Math.abs(start.getX() - end.getX());
        int deltaY = Math.abs(start.getY() - end.getY());

        // Knight's unique L-shaped movement (2 squares in one direction and 1 in another)
        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }
}