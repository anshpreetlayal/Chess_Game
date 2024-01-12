public class Pawn extends Piece {
    public Pawn(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    @Override
    public boolean isValidMove(Square destination) {
        return false;
    }
}