public class Pawn extends Piece {
   // private static final Square currentPosition = ;

    public Pawn(String color) {
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