/*
Problem: Jump Game II
Difficulty: Medium

Approach:

1. Use a Greedy approach to minimize the number of jumps.
2. Maintain three variables:
   - jumps: Number of jumps taken.
   - currentEnd: The farthest index reachable with the current jump.
   - farthest: The farthest index reachable while traversing
     the current range.
3. Traverse the array up to the second-last element.
4. Update the farthest reachable index.
5. When the current index reaches currentEnd:
   - Increment the jump count.
   - Update currentEnd to farthest.
6. Continue until the last index is reachable.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}