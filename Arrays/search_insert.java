/*
Problem: Search Insert Position
Difficulty: Easy

Approach:

1. Use Binary Search to locate the target.
2. If the target is found, return its index.
3. If the target is not found, the variable 'low'
   will indicate the correct insertion position.
4. Return low after the binary search completes.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] < target) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return low;
    }
}