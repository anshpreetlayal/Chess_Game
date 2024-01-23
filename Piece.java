public abstract class Piece {
    private boolean isWhite;
    private String color;
    private Square currentPosition;
    private boolean isKilled = false;

    public Piece(String color, Square currentPosition) {
        this.color = color;
        this.currentPosition = currentPosition;
        // Derive isWhite from the color
        this.isWhite = "white".equalsIgnoreCase(color);
    }

    public abstract boolean isValidMove(Square destination);

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Square getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Square currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public void setWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isKilled() {
        return this.isKilled;
    }

    public void setKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public abstract boolean canMove(Board board, Square start, Square end);
}
}