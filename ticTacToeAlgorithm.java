//Author information:
  //Author: Madeline Savoiu
  //Email: savoiu@csu.fullerton.edu

//Program information:
  //Program name: Tic-Tac-Toe
  //Programming language: Java
  //Files: testTicTacToe.java, ticTacToeFrame.java, ticTacToeAlgorithm.java, run.sh
  //Date project began:  2025-Sept-21
  //Date of last update: 2025-Sept-28
  //Status: Complete
  //Nice feature: Human player cannot select squares on the game board before the game begins and the computer makes its move.
  //Base test system: Linux system with Bash shell and openjdk-14-jdk.

  //This module
  //File name: ticTacToeAlgorithm.java
  //Compile : javac ticTacToeAlgorithm.java
  //Purpose: This class defines functions for determining whether either player has won the game yet
  //This module (class) is called from the ticTacToeFrame class.

public class ticTacToeAlgorithm {
    // 0 -> empty cell, 1 -> X, 2 -> O

    public static boolean humanWon(int[][] board) {
        return hasWon(board, 1);
    }

    public static boolean computerWon(int[][] board) {
        return hasWon(board, 2);
    }

    // Helper method
    private static boolean hasWon(int[][] board, int player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player &&
                board[1][j] == player &&
                board[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player) {
            return true;
        }

        // No win so far
        return false;
    }
}
