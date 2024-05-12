import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new chess board
        Board board = new Board(8, 8);

        // Create players
        Player player1 = new Player("Player 1", PlayerColor.WHITE);
        Player player2 = new Player("Player 2", PlayerColor.BLACK);

        // Start the game loop
        boolean gameOver = false;
        Player currentPlayer = player1; // Player 1 starts
        while (!gameOver) {
            // Display the board
            board.displayBoard();

            // Take a turn for the current player
            takeTurn(currentPlayer, board);

            // Check if the game is over (e.g., checkmate, stalemate)
            // Implement this logic

            // Switch to the other player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private static void takeTurn(Player player, Board board) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(player.getName() + "'s turn:");

            // Display the board
            board.displayBoard();

            // Get the piece to move
            System.out.print("Enter the row and column of the piece you want to move (e.g., '2 3'): ");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();
            Square startSquare = board.getSquare(startRow, startCol);

            if (startSquare == null || startSquare.getPiece() == null || startSquare.getPiece().isWhite() != player.isWhite()) {
                System.out.println("Invalid piece or not your turn. Please try again.");
                continue;
            }

            // Get the destination square
            System.out.print("Enter the row and column of the destination square (e.g., '4 5'): ");
            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();
            Square endSquare = board.getSquare(endRow, endCol);

            if (endSquare == null) {
                System.out.println("Invalid destination. Please try again.");
                continue;
            }

            // Check if the move is valid
            if (!startSquare.getPiece().canMove(board, startSquare, endSquare)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            // Move the piece
            Piece piece = startSquare.getPiece();
            endSquare.setPiece(piece);
            startSquare.setPiece(null);
            piece.setCurrentPosition();

            // Check for checkmate
            if (isCheckmate(player.isWhite(), board)) {
                System.out.println(player.getName() + " is in checkmate. Game over!");
                board.displayBoard();
                System.exit(0);
            }

            break;
        }
    }


    private static boolean isCheckmate(boolean isWhite, Board board) {
            // Find the king of the current player
            Piece king = findKing(isWhite, board);
            if (king == null) {
                return false; // King not found (should not happen)
            }

            // Check if the king is in check
            Square kingSquare = king.getCurrentPosition();
            if (!isUnderAttack(kingSquare, isWhite, board)) {
                return false; // King is not in check
            }

            // Check if the king can move to safety
            for (int row = kingSquare.getRow() - 1; row <= kingSquare.getRow() + 1; row++) {
                for (int col = kingSquare.getCol() - 1; col <= kingSquare.getCol() + 1; col++) {
                    if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                        Square destination = board.getSquare(row, col);
                        if (king.canMove(board, kingSquare, destination)) {
                            return false; // King can move to safety
                        }
                    }
                }
            }

            // The king cannot move to safety, and no other piece can block the check
            return true; // Checkmate
        }

    private static Piece findKing(boolean isWhite, Board board) {
        // Iterate over all squares to find the king of the specified color
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square square = board.getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece instanceof King && piece.isWhite() == isWhite) {
                    return piece; // Found the king
                }
            }
        }
        return null; // King not found
    }

    private static boolean isUnderAttack(Square square, boolean isWhite, Board board) {
        // Iterate over all squares to check if any opponent's piece can attack the specified square
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Square attackerSquare = board.getSquare(row, col);
                Piece attacker = attackerSquare.getPiece();
                if (attacker != null && attacker.isWhite() != isWhite && attacker.canMove(board, attackerSquare, square)) {
                    return true; // The square is under attack
                }
            }
        }
        return false; // The square is not under attack
    }

    public static Piece findKing(Player player) {
        Board board = player.getGame().getBoard();
        for (int row = 0; row < board.getNumRows(); row++) {
            for (int col = 0; col < board.getNumCols(); col++) {
                Square square = board.getSquare(row, col);
                Piece piece = square.getPiece();
                if (piece instanceof King && piece.getColor().equals(player.getColor())) {
                    return piece; // Found the king
                }
            }
        }
        return null; // King not found
    }




}

