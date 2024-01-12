public abstract class Piece {
    private String color;
    private Square currentPosition;

    public Piece(String color, Square currentPosition) {
        this.color = color;
        this.currentPosition = currentPosition;
    }

    // Abstract method to be implemented by specific piece classes
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
}