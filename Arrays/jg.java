/*
Problem: Jump Game
Difficulty: Medium

Approach:

1. Initialize a variable 'maxReach' to 0.
2. Traverse the array from left to right.
3. If the current index is greater than maxReach,
   the current position is unreachable, so return false.
4. Update:
      maxReach = max(maxReach, i + nums[i])
5. If maxReach reaches or exceeds the last index,
   return true.
6. If the loop completes, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}