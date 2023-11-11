enum PieceType {
    PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
}

class Piece {
    private PieceType type;
    private boolean isWhite;

    public Piece(PieceType type, boolean isWhite){
         this.type = type;
         this.isWhite = isWhite;
    }

    public PieceType getType(){
        return type;
    }

    public boolean isWhite(){
        return isWhite;
    }
}