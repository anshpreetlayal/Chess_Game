public abstract class ChessPiece {
    private boolean isCaptured = false;
    private boolean isWhite = false;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }
}