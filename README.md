
---

# Chess Game Implementation in Java

This project is a simple implementation of a chess game in Java. It allows two players to make moves on a command-line interface.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [File Structure](#file-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Overview

This project simulates a basic chess game allowing two players to take turns making moves. The game enforces basic rules such as piece movements, captures, and rudimentary checkmate conditions.

## Features

- Command-line interface for player input and displaying the chessboard.
- Movement validation for individual chess pieces.
- Players can make moves following the basic rules of chess.
- Win conditions of checkmate and stalemate.

## File Structure

The project consists of the following classes:

- `ChessGame`: Manages the game flow, players, and the game loop.
- `Board`: Represents the chessboard and handles the board state and piece placement.
- `ChessPiece`: An abstract class for all chess pieces, includes common attributes and abstract methods for movement.
- Individual Piece Classes: `Pawn`, `Rook`, `Knight`, `Bishop`, `Queen`, `King` for specific piece logic.
- `Cell`: Represents a cell on the chessboard.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

### Installation

1. Clone this repository.
2. Open the project in your preferred IDE.

## Usage

1. Run the `ChessGame.java` file to start the game.
2. Follow the command-line instructions to input moves in the format, e.g., 'a2 a4'.
3. Take turns between players and play until a win condition is met.

## Contributing

Contributions are welcome! If you'd like to improve the game by adding new features, improving existing functionalities, or fixing issues, feel free to fork the repository and create a pull request.



