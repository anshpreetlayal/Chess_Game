import java.util.Scanner;

public class ChessGame {
    private Board chessBoard;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;
    public ChessGame() {
        chessBoard = new Board();
        whitePlayer = new Player("White");
        blackPlayer = new Player("Black");
        currentPlayer = whitePlayer;
    }