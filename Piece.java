public abstract class Piece {
    private boolean isCaptured = false;
    private boolean isWhite = false;

    public Piece(boolean isWhite) {
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

    public abstract boolean isValidMove(Board board, Spot start, Spot end);

    public abstract boolean isValidMove(Board board, GridBlock start, GridBlock end);
}

