class Solution {
    public boolean isWordExist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        // Try to start search from each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Helper DFS to check word existence
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        // Boundary and character check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        // Move in 4 possible directions (up, down, left, right)
        boolean found = dfs(board, word, i + 1, j, index + 1, visited)
                || dfs(board, word, i - 1, j, index + 1, visited)
                || dfs(board, word, i, j + 1, index + 1, visited)
                || dfs(board, word, i, j - 1, index + 1, visited);

        visited[i][j] = false; // backtrack

        return found;
    }
}
