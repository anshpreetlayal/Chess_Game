public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite);
    }


    @Override
    public boolean isValidMove(ChessBoard board, GridBlock start, GridBlock end) {
        if () {
            return false;
        }

        int deltaX = Math.abs(start.getX() - end.getX());
        int deltaY = Math.abs(start.getY() - end.getY());

        // Queen can move horizontally, vertically, or diagonally
        return deltaX == 0 || deltaY == 0 || deltaX == deltaY;
    }
}
