public class Queen extends Piece{

    public Queen(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // Queen can move horizontally, vertically, or diagonally
        return rowDiff == 0 || colDiff == 0 || rowDiff == colDiff;
    }
    @Override
    public boolean canMove(Board board, Square start, Square end) {
        return false;
    }
}