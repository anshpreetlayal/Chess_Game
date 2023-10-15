public abstract class ChessPiece {
    private String name;
    private boolean isWhite;
    private  boolean isBlack;

    public ChessPiece(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }
    public boolean isWhite() {
        return isWhite;
    }
    public String getName() {
        return name;
    }

    public abstract boolean isValidMove(Cell start, Cell end);
}