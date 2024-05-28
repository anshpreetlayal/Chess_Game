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
                try (Scanner scanner = new Scanner(System.in)) {
                    while (!gameOver) {
                        // Display the board
                        board.displayBoard();

                        // Take a turn for the current player
                        takeTurn(currentPlayer, board, scanner);

                        // Check if the game is over (e.g., checkmate, stalemate)
                        gameOver = isGameOver(currentPlayer, board);

                        // Switch to the other player
                        currentPlayer = (currentPlayer == player1) ? player2 : player1;
                    }
                }
            }

            private static void takeTurn(Player player, Board board, Scanner scanner) {
                while (true) {
                    System.out.println(player.getName() + "'s turn:");

                    // Get the piece to move
                    System.out.print("Enter the row and column of the piece you want to move (e.g., '2 3'): ");
                    int startRow = scanner.nextInt();
                    int startCol = scanner.nextInt();
                    Square startSquare = board.getSquare(startRow, startCol);

                    if (!isValidMove(startSquare, player)) {
                        System.out.println("Invalid piece or not your turn. Please try again.");
                        continue;
                    }

                    // Get the destination square
                    System.out.print("Enter the row and column of the destination square (e.g., '4 5'): ");
                    int endRow = scanner.nextInt();
                    int endCol = scanner.nextInt();
                    Square endSquare = board.getSquare(endRow, endCol);

                    if (endSquare == null || !startSquare.getPiece().canMove(board, startSquare, endSquare)) {
                        System.out.println("Invalid move. Please try again.");
                        continue;
                    }

                    // Move the piece
                    Piece piece = startSquare.getPiece();
                    endSquare.setPiece(piece);
                    startSquare.setPiece(null);
                    piece.setCurrentPosition(endRow, endCol);

                    break;
                }
            }

            private static boolean isValidMove(Square startSquare, Player player) {
                return startSquare != null && startSquare.getPiece() != null && startSquare.getPiece().isWhite() == player.isWhite();
            }

            private static boolean isGameOver(Player currentPlayer, Board board) {
                boolean isWhite = currentPlayer.isWhite();
                Piece king = findKing(isWhite, board);
                if (king == null) return true; // King not found (should not happen)

                Square kingSquare = king.getCurrentPosition();
                if (!isUnderAttack(kingSquare, isWhite, board)) return false; // King is not in check

                for (int row = kingSquare.getRow() - 1; row <= kingSquare.getRow() + 1; row++) {
                    for (int col = kingSquare.getCol() - 1; col <= kingSquare.getCol() + 1; col++) {
                        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
                            Square destination = board.getSquare(row, col);
                            if (king.canMove(board, kingSquare, destination)) return false; // King can move to safety
                        }
                    }
                }

                return true; // Checkmate
            }

            private static Piece findKing(boolean isWhite, Board board) {
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
        }
