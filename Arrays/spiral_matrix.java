/*
Problem: Spiral Matrix
Difficulty: Medium

Approach:

1. Use four boundaries:
   - top
   - bottom
   - left
   - right
2. Traverse the matrix in four directions:
   - Left → Right
   - Top → Bottom
   - Right → Left
   - Bottom → Top
3. After each traversal, move the corresponding boundary inward.
4. Continue until all elements are visited.

Time Complexity: O(m × n)
Space Complexity: O(1) (excluding the output list)
*/

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // Left -> Right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Top -> Bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Right -> Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Bottom -> Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}