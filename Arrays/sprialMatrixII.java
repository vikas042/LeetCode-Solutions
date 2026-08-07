/*
Problem: Spiral Matrix II
Difficulty: Medium

Approach:

1. Create an n x n matrix.
2. Maintain four boundaries:
   - top
   - bottom
   - left
   - right
3. Fill numbers from 1 to n² in spiral order:
   - Left → Right
   - Top → Bottom
   - Right → Left
   - Bottom → Top
4. Shrink the boundaries after completing each direction.
5. Continue until all cells are filled.

Time Complexity: O(n²)
Space Complexity: O(1) (excluding output matrix)
*/

class Solution {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;

        while (top <= bottom && left <= right) {

            // Left -> Right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // Top -> Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // Right -> Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            // Bottom -> Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }

        return matrix;
    }
}