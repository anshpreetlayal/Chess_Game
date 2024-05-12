import java.util.Scanner;

public class Game {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;

    public Board getBoard() {
        return board;
    }

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Start with player1
    }

    public void startGame() {
        System.out.println("Chess Game Started!");

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
                System.out.println("Invalid input. Please enter valid row and column numbers.");
            } else if (startSquare.getPiece() == null) {
                System.out.println("There is no piece at the selected starting square. Please choose again.");
            } else if (startSquare.getPiece().isWhite() != currentPlayer.isWhite()) {
                System.out.println("You can only move your own pieces. Please select a square with your piece.");
            } else if (!startSquare.getPiece().canMove(board, startSquare, endSquare)) {
                System.out.println("Invalid move for the selected piece. Please try again.");
            }
        } while (startSquare == null || endSquare == null || startSquare.getPiece() == null
                || !startSquare.getPiece().canMove(board, startSquare, endSquare));

        // Perform the move
        endSquare.setPiece(startSquare.getPiece());
        startSquare.setPiece(null);
    }


    private void switchPlayer() {

        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean isGameOver() {
        return isCheckmate(player1) || isCheckmate(player2) || isStalemate(player1) || isStalemate(player2);
    }
    private boolean isCheckmate(Player player) {
        Piece king = Main.findKing(player);
        if (king != null && isInCheck(king, player)) {
            // Check if the king has no legal moves to escape check
            return !hasLegalMoves(king, player);
        }
        return false;
    }

    //private boolean isInCheck(Piece piece, Player player) {
        // Check if the piece is under attack by opponent's pieces
        // Implement logic to check if the piece is under attack
      //  return false; // to be replaced with logic
   // }

   // private boolean hasLegalMoves(Piece piece, Player player) {
        // Check if the piece has legal moves to escape check

     //   return false; // to be replaced with actual logic
   // }



    private boolean isStalemate(Player player) {
        // Check if the player has legal moves but is not in check
        for (Square[] row : board.getSquares()) {
            for (Square square : row) {
                Piece piece = square.getPiece();
                if (piece != null && piece.getColor() == player.getColor() && hasLegalMoves(piece, player)) {
                    return false; // Player has at least one legal move
                }
            }
        }
        return true; // Player has no legal moves
    }


    private void displayBoard() {
            Square[][] squares = board.getSquares();
            System.out.println("Current Board:");
            for (int row = 0; row < squares.length; row++) {
                for (int col = 0; col < squares[row].length; col++) {
                    Square square = squares[row][col];
                    Piece piece = square.getPiece();
                    if (piece != null) {
                        System.out.print(piece.getSymbol() + " ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println("Current Board:");
            }
        }


    private void displayResult() {
        if (isCheckmate(player1)) {
            System.out.println("Player 1 is in checkmate. Player 2 wins!");
        } else if (isCheckmate(player2)) {
            System.out.println("Player 2 is in checkmate. Player 1 wins!");
        } else if (isStalemate(player1) || isStalemate(player2)) {
            System.out.println("Stalemate! The game is a draw.");
        } else {
            System.out.println("Game Over! Display result here.");
        }
        }


    private boolean isInCheck(Piece piece, Player player) {
        // Get the opponent's color
        PlayerColor opponentColor = (player == player1) ? PlayerColor.BLACK : PlayerColor.WHITE;

        // Get all squares on the board
        Square[][] squares = board.getSquares();

        // Iterate through all squares to find opponent's pieces and check if they can attack the piece
        for (Square[] row : squares) {
            for (Square square : row) {
                Piece attacker = square.getPiece();
                if (attacker != null && attacker.getColor() == opponentColor && attacker.canMove(board, square, piece.getCurrentPosition())) {
                    return true; // Piece is under attack
                }
            }
        }
        return false; // Piece is not under attack
    }

    private boolean hasLegalMoves(Piece piece, Player player) {
        // Get all squares on the board
        Square[][] squares = board.getSquares();

        // Iterate through all squares to check if the piece has any legal moves
        for (Square[] row : squares) {
            for (Square square : row) {
                if (piece.canMove(board, piece.getCurrentPosition(), square)) {
                    // Simulate the move and check if the king is still in check
                    Piece currentPiece = square.getPiece();
                    square.setPiece(piece);
                    piece.getCurrentPosition().setPiece(null);
                    boolean legalMove = !isInCheck(Main.findKing(player), player);
                    square.setPiece(currentPiece);
                    piece.getCurrentPosition().setPiece(piece);
                    if (legalMove) {
                        return true; // Piece has legal moves
                    }
                }
            }
        }
        return false; // Piece has no legal moves
    }

}
