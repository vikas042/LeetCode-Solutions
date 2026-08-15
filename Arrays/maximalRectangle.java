/*
Problem: Maximal Rectangle
Difficulty: Hard

Approach:

1. Convert each row into a histogram.
2. For every '1', increase its height.
3. For every '0', reset its height to 0.
4. Find the largest rectangle in the histogram
   using a monotonic increasing stack.
5. Keep track of the maximum rectangle area.

Time Complexity: O(rows * cols)
Space Complexity: O(cols)
*/

class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private int largestRectangle(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight;

            if (i == heights.length) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            while (!stack.isEmpty()
                    && currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}