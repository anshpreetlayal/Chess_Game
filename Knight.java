public class Knight extends Piece {

    public Knight(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    @Override
    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // Knight moves in an L-shape: two squares in one direction and one square perpendicular
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is a valid move for the Knight
        return isValidMove(end) && (end.getPiece() == null || end.getPiece().isWhite() != this.isWhite());
    }
}
