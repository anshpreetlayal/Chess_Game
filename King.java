public class King extends Piece {
    private boolean castlingDone = false;
    private Board board; // Define the board field

    public King(String color, Square currentPosition, Board board) {
        super(PieceColor.valueOf(color), currentPosition);
        this.board = board;
    }

    public boolean isCastlingDone() {
        return this.castlingDone;
    }

    @Override
    public boolean isValidMove(Square destination) {
        int rowDiff = Math.abs(destination.getRow() - getCurrentPosition().getRow());
        int colDiff = Math.abs(destination.getCol() - getCurrentPosition().getCol());

        // King can move one square in any direction
        return rowDiff <= 1 && colDiff <= 1;
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        // Check if the destination square is a valid move for the King
        if (!isValidMove(end)) {
            return false;
        }

        // Check if there are no pieces in the path of the King
        if (end.getPiece() != null && end.getPiece().getColor().equals(this.getColor())) {
            return false; // Cannot capture a piece of the same color
        }

        int rowDiff = Math.abs(end.getRow() - start.getRow());
        int colDiff = Math.abs(end.getCol() - start.getCol());

        // Check if the king is moving more than one square
        if (rowDiff > 1 || colDiff > 1) {
            return false;
        }

        // Check if the destination square is under attack by an opponent's piece
        if (isSquareUnderAttack(board, end)) {
            return false;
        }

        // Additional logic for specific rules related to moving the King on the board
        // Implement as needed based on the specific rules of chess

        return true;
    }

    @Override
    public String getSymbol() {
        return null;
    }

    private boolean isSquareUnderAttack(Board board, Square square) {
        // Logic to check if the square is under attack by an opponent's piece
        // Implement this method based on the specific rules of chess
        return false; // Placeholder - replace with actual implementation
    }

    public boolean isCastlingMove(Square start, Square end) {
        // Check if the move is a castling move
        if (isCastlingDone()) {
            return false; // Castling already done
        }

        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();

        // Check if the move is a castling move to the right
        if (startRow == endRow && Math.abs(startCol - endCol) == 2) {
            // Check if the king is in its initial position
            if (startCol == 4) {
                // Check if there is a rook on the corner
                Square rookSquare = null;
                if (endCol == 6) {
                    rookSquare = board.getSquare(startRow, 7); // Right rook
                } else if (endCol == 2) {
                    rookSquare = board.getSquare(startRow, 0); // Left rook
                }

                if (rookSquare != null) {
                    Piece rook = rookSquare.getPiece();
                    if (rook != null && rook instanceof Rook && !rook.isKilled()) {
                        // Check if there are no pieces between the king and the rook
                        int direction = endCol > startCol ? 1 : -1;
                        for (int col = startCol + direction; col != endCol; col += direction) {
                            Square betweenSquare = board.getSquare(startRow, col);
                            if (betweenSquare != null && betweenSquare.getPiece() != null) {
                                return false; // There is a piece between the king and the rook
                            }
                        }

                        // Check if the squares the king crosses during castling are not under attack
                        // Check if the king is not in check and does not end up in check after castling

                        return true; // Castling move is valid
                    }
                }
            }
        }

        return false; // Not a valid castling move
    }

}
