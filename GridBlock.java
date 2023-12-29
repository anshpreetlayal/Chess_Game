public class GridBlock {
    private ChessPiece piece;
    private int x;
    private int y;

    public GridBlock(int x, int y, ChessPiece piece) {
        this.setPiece(piece);
        this.setX(x);
        this.setY(y);
    }
    public ChessPiece getPiece() {
        return this.piece;
    }

    public void setPiece(ChessPiece p) {
        this.piece = p;
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
