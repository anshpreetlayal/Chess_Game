public class Knight extends Piece {
    public Knight (String color, Square currentPosition) {
        super(color);
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