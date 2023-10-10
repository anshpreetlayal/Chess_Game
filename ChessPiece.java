
abstract class ChessPiece {
    private boolean isWhite;
    private boolean isBlack;
    public abstract boolean isValidMove(Cell from, Cell to);

}
