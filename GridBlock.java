public class GridBlock {
    private Piece piece;
    private int x;
    private int y;

    public GridBlock(int x, int y, Piece piece) {
        this.piece = piece;
        this.x = x;
        this.y = y;
    }
    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
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
