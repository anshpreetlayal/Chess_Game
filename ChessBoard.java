import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private Map<String, Spot> board;

    public ChessBoard() {
        this.board = new HashMap<>();
        initializeBoard();
        initializePieces();
    }

    private void initializeBoard() {
        for (int i = 1; i <= 8; i++) {
            for (char j = 'A'; j <= 'H'; j++) {
                String key = Character.toString(j) + i;
                board.put(key, new Spot(i, j));
            }
        }
    }
    private void initializePieces() {
        // White pieces
        placePiece(new Rook(true), 1, 'A');
        placePiece(new Knight(true), 1, 'B');
        placePiece(new Bishop(true), 1, 'C');
        placePiece(new Queen(true), 1, 'D');
        placePiece(new King(true), 1, 'E');
        placePiece(new Bishop(true), 1, 'F');
        placePiece(new Knight(true), 1, 'G');
        placePiece(new Rook(true), 1, 'H');
        for (char i = 'A'; i <= 'H'; i++) {
            placePiece(new Pawn(true), 2, i);
        }

        // Black pieces
        placePiece(new Rook(false), 8, 'A');
        placePiece(new Knight(false), 8, 'B');
        placePiece(new Bishop(false), 8, 'C');
        placePiece(new Queen(false), 8, 'D');
        placePiece(new King(false), 8, 'E');
        placePiece(new Bishop(false), 8, 'F');
        placePiece(new Knight(false), 8, 'G');
        placePiece(new Rook(false), 8, 'H');
        for (char i = 'A'; i <= 'H'; i++) {
            placePiece(new Pawn(false), 7, i);
        }
    }

    public Spot getSpot(int x, char y) {
        String key = Character.toString(y) + x;
        return board.get(key);
    }

    public void placePiece(ChessPiece piece, int x, char y) {
        Spot spot = getSpot(x, y);
        if (spot != null) {
            spot.setPiece(piece);
        }
    }
    public boolean movePiece(int startX, char startY, int endX, char endY) {
        Spot startSpot = getSpot(startX, startY);
        Spot endSpot = getSpot(endX, endY);

        if (startSpot != null && endSpot != null) {
            ChessPiece piece = startSpot.getPiece();
            if (piece != null && piece.isValidMove(this, startSpot, endSpot)) {
                endSpot.setPiece(piece);
                startSpot.setPiece(null);
                return true;
            }
        }
        return false;
    }
    public void displayBoard() {
        for (int i = 8; i >= 1; i--) {
            for (char j = 'A'; j <= 'H'; j++) {
                Spot spot = getSpot(i, j);
                ChessPiece piece = spot.getPiece();
                if (piece != null) {
                    System.out.print(piece.getSymbol() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}