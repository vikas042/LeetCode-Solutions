/*
Problem: Trapping Rain Water
Difficulty: Hard

Approach:

1. Initialize two pointers:
      - left = 0
      - right = n - 1
2. Maintain:
      - leftMax = highest bar from the left.
      - rightMax = highest bar from the right.
3. While left < right:
      - If height[left] < height[right]:
          a) Update leftMax if needed.
          b) Otherwise, trap (leftMax - height[left]) water.
          c) Move left forward.
      - Else:
          a) Update rightMax if needed.
          b) Otherwise, trap (rightMax - height[right]) water.
          c) Move right backward.
4. Return the total trapped water.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}