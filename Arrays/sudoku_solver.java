/*
Problem: Sudoku Solver
Difficulty: Hard

Approach:

1. Use Backtracking to solve the Sudoku.
2. Traverse the board to find an empty cell ('.').
3. Try placing digits '1' to '9' in the empty cell.
4. Before placing a digit, verify that it does not
   already exist in the same row, column, or 3×3 box.
5. If the placement is valid:
   - Place the digit.
   - Recursively solve the remaining board.
6. If recursion fails, remove the digit and try the
   next one (Backtracking).
7. Once all cells are filled successfully, the Sudoku
   is solved.

Time Complexity: O(9^(n)) (Backtracking, worst case)
Space Complexity: O(n) (Recursion stack)
*/

class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {

                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == num) {
                return false;
            }

            if (board[i][col] == num) {
                return false;
            }

            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }

        return true;
    }
} 

    

