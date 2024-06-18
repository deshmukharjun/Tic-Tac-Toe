# Tic-Tac-Toe Android Game

This is a simple Tic-Tac-Toe game for Android. The game allows two players to play against each other on the same device. It includes basic features such as player turns, win detection, and a restart button.

## Features

- Two-player game
- Alternating turns between players (X and O)
- Win detection for rows, columns, and diagonals
- Tie detection
- Game restart functionality

## Installation

1. Clone the repository to your local machine:
    ```sh
    git clone https://github.com/deshmukharjun/tictactoe.git
    ```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or physical device.

## Usage

1. Launch the app on your Android device.
2. Tap on an empty cell to make a move.
3. Players take turns tapping on empty cells.
4. The game will display a message when a player wins or if the game ends in a tie.
5. Press the "Restart" button to reset the game.

## Code Overview

### MainActivity.java

- **Variables**:
  - `activePlayer`: Tracks the current player (0 for X, 1 for O).
  - `gameState`: Array to store the state of the board (0 for X, 1 for O, 2 for empty).
  - `winPositions`: Array of winning positions.
  - `gameActive`: Boolean to track if the game is active.

- **Methods**:
  - `playerTap(View view)`: Handles player taps on the board. Updates the game state and checks for a win or tie.
  - `checkGameStatus()`: Checks the current state of the game to determine if there is a win or tie.
  - `restartGame(View view)`: Resets the game to its initial state.

- **Lifecycle**:
  - `onCreate(Bundle savedInstanceState)`: Initializes the activity and hides the restart button.


## Acknowledgments

- This project was developed as a learning exercise for Android development.
- Icons and images are sourced from [source].

