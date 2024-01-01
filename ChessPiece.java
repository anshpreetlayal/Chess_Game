public abstract class ChessPiece {
    private boolean isCaptured = false;
    private boolean isWhite = false;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean isBlack() {
        return !this.isWhite;
    }

    public boolean isCaptured() {
        return this.isCaptured;
    }

    public void capture() {
        this.isCaptured = true;
    }

    public void release() {
        this.isCaptured = false;
    }

    public abstract  boolean isValidMove(ChessBoard board, Spot start, Spot end);
}