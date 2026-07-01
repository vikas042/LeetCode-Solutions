/*
Problem: Search in Rotated Sorted Array
Difficulty: Medium

Approach:
1. Use Binary Search on the rotated sorted array.
2. In every iteration, determine which half (left or right)
   is sorted.
3. Check whether the target lies within the sorted half.
4. If it does, continue searching in that half.
5. Otherwise, search in the other half.
6. Repeat until the target is found or the search space
   becomes empty.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {

                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}