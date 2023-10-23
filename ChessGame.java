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
    public void startGame() {
        boolean isGameOver = false;
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver) {
            // Display the current state of the board
            chessBoard.displayBoard();

            // Get the player's move input
            System.out.print(currentPlayer.getName() + "'s turn. Enter your move (e.g., 'a2 a4'): ");
            String move = scanner.nextLine();