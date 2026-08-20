/*
Problem: Surrounded Regions
Difficulty: Medium

Approach:

1. Find all 'O' cells on the boundary.
2. Run DFS from each boundary 'O'.
3. Mark all connected 'O' cells as 'S' (safe).
4. Traverse the board:
   - 'O' -> surrounded -> change to 'X'
   - 'S' -> safe -> change back to 'O'

Time Complexity: O(m * n)
Space Complexity: O(m * n)
*/

class Solution {

    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        
        for (int j = 0; j < cols; j++) {

            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {

            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O') {

                    board[i][j] = 'X';

                } else if (board[i][j] == 'S') {

                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {

        int rows = board.length;
        int cols = board[0].length;

      
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols) {
            return;
        }

        if (board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'S';

        dfs(board, row - 1, col);

        dfs(board, row + 1, col);

        dfs(board, row, col - 1);

        dfs(board, row, col + 1);
    }
}