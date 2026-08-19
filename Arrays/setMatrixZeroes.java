/*
Problem: Set Matrix Zeroes
Difficulty: Medium

Approach:

1. Use the first row and first column as markers.
2. Store whether the original first row contains zero.
3. Store whether the original first column contains zero.
4. Use matrix[i][0] to mark a row.
5. Use matrix[0][j] to mark a column.
6. Set marked cells to zero.
7. Finally, process the first row and first column.

Time Complexity: O(m * n)
Space Complexity: O(1)
*/

class Solution {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int j = 0; j < n; j++) {

            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 0; i < m; i++) {

            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == 0) {

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (matrix[i][0] == 0
                        || matrix[0][j] == 0) {

                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {

            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        
        if (firstColZero) {

            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}