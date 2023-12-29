public class GridBlock {
    private ChessPiece piece;
    private int x;
    private int y;

    public GridBlock(int x, int y, ChessPiece piece) {
        this.setPiece(piece);
        this.setX(x);
        this.setY(y);
    }

}