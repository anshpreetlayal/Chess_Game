public class Rook extends Piece {

    public Rook(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    @Override
    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // Rook can move horizontally or vertically
        return rowDiff == 0 || colDiff == 0;
    }
}