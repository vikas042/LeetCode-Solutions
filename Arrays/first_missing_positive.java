/*
Problem: First Missing Positive
Difficulty: Hard

Approach:

1. Rearrange the array using Cyclic Sort.
2. For each element:
   - If it is in the range [1, n]
   - And it is not already in its correct position,
     swap it with the element at its correct index.
3. After rearrangement, traverse the array.
4. The first index where nums[i] != i + 1
   is the smallest missing positive.
5. If every number is in its correct position,
   return n + 1.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        int i = 0;

        while (i < n) {

            int correctIndex = nums[i] - 1;

            if (nums[i] > 0 &&
                nums[i] <= n &&
                nums[i] != nums[correctIndex]) {

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }

            else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}