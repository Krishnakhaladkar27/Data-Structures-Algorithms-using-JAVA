class Solution {
    // Function to find a solved Sudoku grid
    static boolean SolveSudoku(int[][] mat) {
        return solve(mat);
    }

    // Recursive function to solve Sudoku using backtracking
    private static boolean solve(int[][] mat) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(mat, row, col, num)) {
                            mat[row][col] = num;
                            if (solve(mat)) {
                                return true;
                            } else {
                                mat[row][col] = 0; // Backtrack
                            }
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    // Check if placing num in mat[row][col] is valid
    private static boolean isSafe(int[][] mat, int row, int col, int num) {
        // Check row
        for (int x = 0; x < 9; x++) {
            if (mat[row][x] == num) return false;
        }

        // Check column
        for (int x = 0; x < 9; x++) {
            if (mat[x][col] == num) return false;
        }

        // Check 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (mat[i][j] == num) return false;
            }
        }

        return true;
    }

    // Function to print the solved Sudoku
    static void printGrid(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
    }
}
