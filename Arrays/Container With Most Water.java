/*
Problem: Container With Most Water
Difficulty: Medium

Approach:
1. Initialize two pointers:
   - left at the beginning of the array.
   - right at the end of the array.
2. Calculate the area formed by the two lines:
   - width = right - left
   - height = min(height[left], height[right])
   - area = width × height
3. Update the maximum area found so far.
4. Move the pointer with the smaller height inward because the shorter line limits the container's height.
5. Continue until the two pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int area = width * currentHeight;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}