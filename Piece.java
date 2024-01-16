public abstract class Piece {
    private String color;
    private Square currentPosition;
    private boolean isKilled = false;
    private boolean isWhite = false;

    public Piece(String color) {
        this.color = color;
        this.currentPosition = currentPosition;
        this.isWhite = isWhite;
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