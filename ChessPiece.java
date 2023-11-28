import java.util.ArrayList;

public class Board {

    public final String WHITE = "white";
    public final String BLACK = "black";

    // 2D array representing the chessboard
    public Square[][] squares;

    // Variables representing individual pieces
    Piece wr1, wr2, wn1, wn2, wb1, wb2, wq, wk, wp[];
    Piece br1, br2, bn1, bn2, bb1, bb2, bq, bk, bp[];
