/*
Problem: Search a 2D Matrix
Difficulty: Medium

Approach:

1. Treat the matrix as a sorted 1D array.
2. Apply binary search.
3. Convert the 1D index to matrix coordinates:
   row = mid / columns
   col = mid % columns
4. Compare the middle element with the target.

Time Complexity: O(log(m * n))
Space Complexity: O(1)
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            }

            else if (matrix[row][col] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return false;
    }
}