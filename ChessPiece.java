public abstract class ChessPiece {
    private String name;
    private boolean isWhite; // or isBlack

    public ChessPiece(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }
    public boolean isWhite() {
        return isWhite;
    }