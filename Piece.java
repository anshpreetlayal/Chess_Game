public abstract class Piece {
    private final boolean isWhite;
    private final String color;
    private final Square currentPosition;
    private boolean isKilled = false;

    public Piece(String color, Square currentPosition) {
        this.color = color;
        this.isWhite = "white".equalsIgnoreCase(color); // Derive isWhite from color
        this.currentPosition = currentPosition;
    }

    public abstract boolean isValidMove(Square destination);

    public String getColor() {
        return color;
    }

    public Square getCurrentPosition() {
        return currentPosition;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean isKilled() {
        return this.isKilled;
    }

    public void setKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public abstract boolean canMove(Board board, Square start, Square end);
}
