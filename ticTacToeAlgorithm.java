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
