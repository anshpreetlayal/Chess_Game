package ChessPieces;

public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Board board, Spot start, Spot end) {
        return false;
    }


    @Override
    public boolean isValidMove(Board board, GridBlock start, GridBlock end) {
        if () {
            return false;
        }

        int deltaX = Math.abs(start.getX() - end.getX());
        int deltaY = Math.abs(start.getY() - end.getY());

        // ChessPieces.Queen can move horizontally, vertically, or diagonally
        return deltaX == 0 || deltaY == 0 || deltaX == deltaY;
    }
}
