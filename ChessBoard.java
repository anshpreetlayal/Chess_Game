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

private void initializePieces(){

}
}