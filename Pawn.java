public class Pawn extends Piece {



    public Pawn(String color, Square currentPosition) {
        super(color, currentPosition);
    }

    @Override
    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // Pawn can move forward by one square
        // or diagonally forward by one square to capture an opponent's piece
        if (getColor().equalsIgnoreCase("white")) {
            return (rowDiff == 1 && colDiff == 0) || (rowDiff == 1 && colDiff == 1);
        } else {
            return (rowDiff == -1 && colDiff == 0) || (rowDiff == -1 && colDiff == 1);
        }
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is a valid move for the Pawn
        if (!isValidMove(end)) {
            return false;
        }

        // Check if the destination square is occupied by a piece of the same color
        if (end.getPiece() != null && end.getPiece().isWhite() == isWhite()) {
            return false;
        }
    }
}