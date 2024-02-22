public class Bishop extends Piece{

    public Bishop(String color, Square currentPosition) {
        super(color, currentPosition);
    }


    @Override
    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // Bishop can move diagonally any number of squares
        return rowDiff == colDiff;
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {

        return false;
    }
}