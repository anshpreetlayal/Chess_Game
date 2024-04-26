public abstract class Piece {
    private final boolean isWhite;
    private final String color;
    private Square currentPosition;
    private boolean isKilled = false;

    public Piece(String color, Square currentPosition) {
        this.color = color;
        this.isWhite = "white".equalsIgnoreCase(color); 
        this.currentPosition = currentPosition;
    }

    public abstract boolean isValidMove(Square destination);

    public String getColor() {

        return color;
    }

    public void setCurrentPosition(Square newPosition) {

        this.currentPosition = newPosition;
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


    public boolean getSymbol() {

        return false;
    }

    public void setCurrentPosition(int row, int col) {
    }

    public void setCurrentPosition() {
    }
}
