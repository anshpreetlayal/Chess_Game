public abstract class Piece {
    private String color;
    private Square currentPosition;
    private boolean isKilled = false;
    private boolean isWhite = false;

    public Piece(String color, Square currentPosition, boolean isWhite) {
        this.color = color;
        this.currentPosition = currentPosition;
        this.isWhite = isWhite;
    }
}