public class Square {
       private final int row;
        private final int col;
        private Piece piece;

        public Square(int row, int col, Piece piece) {
            this.row = row;
            this.col = col;
            setPiece(piece);
        }

        public Piece getPiece() {
            return piece;
        }

    public void setPiece(Piece piece) {
        this.piece = piece;
        if (piece != null) {
            piece.setCurrentPosition(this);
        }
    }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

