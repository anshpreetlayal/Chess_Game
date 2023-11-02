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
            chessBoard.displayBoard();

            System.out.print(currentPlayer.getName() + "'s turn. Enter your move (e.g., 'a2 a4'): ");
            String move = scanner.nextLine();
            if (isValidMove(move)) {
                chessBoard.makeMove(move);


                if (isCheckmate(currentPlayer)) {
                    System.out.println("Checkmate! " + currentPlayer.getName() + " wins!");
                    isGameOver = true;
                } else if (isStalemate(currentPlayer)) {
                    System.out.println("Stalemate! The game is a draw.");
                    isGameOver = true;
                } else {

                    currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;

                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        scanner.close();
    }