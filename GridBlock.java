public class GridBlock {
    private ChessPiece piece;
    private int x;
    private int y;

    public GridBlock(int x, int y, ChessPiece piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }
    public ChessPiece getPiece() {
        return this.piece;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
