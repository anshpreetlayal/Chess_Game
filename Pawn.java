public class Pawn extends Piece {
    public Pawn(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    @Override
    public boolean isValidMove(Square destination) {
        return false;
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        return false;
    }
}