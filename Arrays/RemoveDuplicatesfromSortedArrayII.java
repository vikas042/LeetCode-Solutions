/*
Problem: Remove Duplicates from Sorted Array II
Difficulty: Medium

Approach:

1. The array is already sorted.
2. Use a write pointer to place valid elements.
3. The first two elements can always be kept.
4. For every next element:
   - If nums[i] is different from nums[k - 2],
     keep it.
   - Otherwise, skip it.
5. Return k, the number of valid elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int k = 2;

        for (int i = 2; i < n; i++) {

            if (nums[i] != nums[k - 2]) {

                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}