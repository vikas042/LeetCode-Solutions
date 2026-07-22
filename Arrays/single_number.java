/*
Problem: Single Number
Difficulty: Easy

Approach:

1. Initialize a variable 'result' to 0.
2. Traverse the array and XOR each element with result.
3. Duplicate numbers cancel each other out because:
      x ^ x = 0
4. The remaining value is the element that appears only once.
5. Return the result.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}