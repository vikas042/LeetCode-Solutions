/*
Problem: Remove Element
Difficulty: Easy

Approach:

1. Use two pointers:
   - i traverses the array.
   - n represents the current valid length.
2. If nums[i] equals val:
   - Replace nums[i] with the last valid element (nums[n-1]).
   - Decrease n.
   - Do not increment i because the swapped element needs to be checked.
3. Otherwise, increment i.
4. Return n as the number of elements that are not equal to val.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }
}