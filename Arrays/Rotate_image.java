/*
Problem: Rotate Image
Difficulty: Medium

Approach:

1. Transpose the matrix:
   - Swap matrix[i][j] with matrix[j][i]
     for all i < j.
2. Reverse each row of the transposed matrix.
3. The matrix is now rotated 90 degrees clockwise
   in-place.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = n - 1;

            while (left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}