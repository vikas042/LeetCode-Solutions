/*
Problem: Maximum Subarray
Difficulty: Medium

Approach:

1. Initialize:
      - currentSum = nums[0]
      - maxSum = nums[0]
2. Traverse the array starting from index 1.
3. At each element:
      - Either extend the current subarray or
        start a new subarray from the current element.
      - Update:
            currentSum = max(nums[i], currentSum + nums[i])
4. Update maxSum if currentSum becomes larger.
5. Return maxSum.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}