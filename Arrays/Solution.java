/*
Problem: Remove Duplicates from Sorted Array
Difficulty: Easy

Approach:

1. Since the array is already sorted, duplicate elements
   appear next to each other.
2. Use two pointers:
   - i keeps track of the last unique element.
   - j traverses the array.
3. Whenever nums[j] is different from nums[i]:
   - Increment i.
   - Copy nums[j] to nums[i].
4. Return i + 1 as the count of unique elements.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
} {
    
}
