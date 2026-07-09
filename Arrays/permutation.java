/*
Problem: Permutations
Difficulty: Medium

Approach:

1. Use Backtracking to generate all possible permutations.
2. Maintain:
   - A list to store the current permutation.
   - A boolean array to track which elements have been used.
3. If the current permutation contains all elements:
   - Add a copy of it to the result.
4. Iterate through all numbers:
   - Skip numbers that are already used.
   - Choose the current number.
   - Mark it as used.
   - Recur to build the remaining permutation.
   - Backtrack by removing the number and marking it as unused.

Time Complexity: O(n × n!)
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, used, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            current.add(nums[i]);

            backtrack(nums, used, current, result);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}