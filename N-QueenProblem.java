import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        int[] board = new int[n]; // board[i] = column index (1-based) of queen in row i
        solve(0, n, board, solutions);
        return solutions;
    }

    private static void solve(int row, int n, int[] board, ArrayList<ArrayList<Integer>> solutions) {
        if (row == n) {
            ArrayList<Integer> config = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                config.add(board[i] + 1); // convert to 1-based column index
            }
            solutions.add(config);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row] = col;
                solve(row + 1, n, board, solutions);
                // Backtrack — no explicit undo needed since board[row] is overwritten
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            int placedCol = board[i];
            // Check same column or diagonal conflict
            if (placedCol == col || Math.abs(placedCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
