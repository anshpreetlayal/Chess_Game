public abstract class ChessPiece{
    boolean isCaptured = false;
    boolean isWhite = false;

    public boolean isWhite() {
        return this.isWhite;
    }

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isCaptured() {
        return this.isCaptured;
    }

    public void capture() {
        this.isCaptured = true;
    }

}

