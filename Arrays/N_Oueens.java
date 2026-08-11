/*
Problem: N-Queens
Difficulty: Hard

Approach:

1. Place one queen in each row.
2. Try every column for the current row.
3. Check whether the position is safe.
4. If safe, place the queen and move to the next row.
5. If the placement leads to no solution, remove the queen
   and try another column.
6. When all rows are filled, add the board to the result.

Time Complexity: O(N!)
Space Complexity: O(N^2)
*/

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];

        boolean[] diag1 = new boolean[2 * n - 1];

        boolean[] diag2 = new boolean[2 * n - 1];

        backtrack(0, n, board, cols, diag1, diag2, result);

        return result;
    }

    private void backtrack(
        int row,
        int n,
        char[][] board,
        boolean[] cols,
        boolean[] diag1,
        boolean[] diag2,
        List<List<String>> result
    ) {

        if (row == n) {

            List<String> currentBoard = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                currentBoard.add(new String(board[i]));
            }

            result.add(currentBoard);
            return;
        }

        for (int col = 0; col < n; col++) {

            int diagonal1 = row - col + n - 1;
            int diagonal2 = row + col;

            if (cols[col] ||
                diag1[diagonal1] ||
                diag2[diagonal2]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[diagonal1] = true;
            diag2[diagonal2] = true;

            backtrack(
                row + 1,
                n,
                board,
                cols,
                diag1,
                diag2,
                result
            );

            board[row][col] = '.';
            cols[col] = false;
            diag1[diagonal1] = false;
            diag2[diagonal2] = false;
        }
    }
}