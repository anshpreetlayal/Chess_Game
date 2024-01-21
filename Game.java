import java.util.Scanner;

public class Game {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Start with player1
    }

    public void startGame() {
        System.out.println("Chess Game Started!");

        // Additional setup or initialization if needed

        playGame();
    }

    private void playGame() {
        while (!isGameOver()) {
            displayBoard();
            takeTurn();
            switchPlayer();
        }

        displayResult();
    }

    private void displayResult() {
    }

    private void switchPlayer() {
    }

    private void displayBoard() {
    }

    private boolean isGameOver() {
    }

    private void takeTurn() {
        Scanner scanner = new Scanner(System.in);
        Square startSquare, endSquare;

        do {
            System.out.println(currentPlayer.getName() + "'s turn:");
            System.out.print("Enter the row and column of the piece you want to move (e.g., '2 3'): ");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();
            startSquare = board.getSquare(startRow, startCol);

            System.out.print("Enter the row and column of the destination square (e.g., '4 5'): ");
            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();
            endSquare = board.getSquare(endRow, endCol);

            if (startSquare == null || endSquare == null) {
                System.out.println("Invalid input. Please try again.");
            } else if (startSquare.getPiece() == null || !startSquare.getPiece().isWhite() == currentPlayer.isWhite()) {
                System.out.println("Invalid move. Choose a square with your own piece.");
            } else if (!startSquare.getPiece().canMove(board, startSquare, endSquare)) {
                System.out.println("Invalid move. Please try again.");
            }
        } while (startSquare == null || endSquare == null || startSquare.getPiece() == null
                || !startSquare.getPiece().canMove(board, startSquare, endSquare));

        // Perform the move
        endSquare.setPiece(startSquare.getPiece());
        startSquare.setPiece(null);
    }


}
