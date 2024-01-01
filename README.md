
---

# Chess Game Implementation in Java

This project is a simple implementation of a chess game in Java. It allows two players to make moves on a command-line interface.

## Overview

This project simulates a basic chess game allowing two players to take turns making moves. The game enforces basic rules such as piece movements, captures, and rudimentary checkmate conditions.

## Features

- Command-line interface for player input and displaying the chessboard.
- Movement validation for individual chess pieces.
- Players can make moves following the basic rules of chess.
- Win conditions of checkmate and stalemate.

## File Structure

The project consists of the following classes:

- GridBlock: Represents a block in an 8×8 grid, optionally containing a piece.
- Piece: Serves as the fundamental element within the system, placed on a GridBlock. This class is abstract. The derived classes (PawnPiece, KingPiece, QueenPiece, RookPiece, KnightPiece, BishopPiece) implement the abstract operations.
- Board: A collection of 8×8 boxes encompassing all active chess pieces.
- Player: Represents one of the players engaged in the game.
- GameMove: Signifies a move in the game, holding information about the starting and ending grid block. Additionally, it tracks the player responsible for the move.
- ChessGame: This class governs the game's progression. It manages all game moves, identifies the current turn's player, and records the game's final outcome.



### Prerequisites

- Java Development Kit (JDK)
- Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

### Installation

1. Clone this repository.
2. Open the project in your preferred IDE.


## Contributing

Contributions are welcome! If you'd like to improve the game by adding new features, improving existing functionalities, or fixing issues, feel free to fork the repository and create a pull request.



