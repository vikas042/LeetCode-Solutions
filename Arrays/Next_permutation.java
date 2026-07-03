/*
Problem: Next Permutation
Difficulty: Medium

Approach:

1. Traverse from right to left and find the first index 'i'
   such that nums[i] < nums[i + 1]. This is the pivot.
2. If a pivot exists:
   - Traverse from the end and find the first element
     greater than nums[i].
   - Swap these two elements.
3. Reverse the subarray from i + 1 to the end to obtain
   the smallest lexicographical order.
4. If no pivot exists, simply reverse the entire array.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // Step 1: Find the pivot
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Find the next greater element and swap
        if (i >= 0) {
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}