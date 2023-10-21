public abstract class ChessPiece {
    private String name;
    private boolean isWhite;

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

class Pawn extends ChessPiece {
    public Pawn(boolean isWhite) {
        super("Pawn", isWhite);
    }
    @Override
    public boolean isValidMove(Cell start, Cell end) {

    }
}
class Rook extends ChessPiece {
    public Rook(boolean isWhite) {
        super("Rook", isWhite);
    }
    public boolean isValidMove(Cell start, Cell end) {

    }
}