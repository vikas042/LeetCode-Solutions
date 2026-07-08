/*
Problem: Combination Sum
Difficulty: Medium

Approach:

1. Use Backtracking to generate all possible combinations.
2. Maintain a temporary list to store the current combination.
3. If the target becomes 0:
   - Add the current combination to the result.
4. If the target becomes negative or all candidates have been
   considered, stop the recursion.
5. Include the current candidate:
   - Add it to the current combination.
   - Recur with the same index since the element can be used
     multiple times.
6. Backtrack by removing the last element.
7. Exclude the current candidate:
   - Move to the next index.

Time Complexity: O(2^target) (Approximate, depends on recursion tree)
Space Complexity: O(target)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        // Include current candidate
        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Exclude current candidate
        backtrack(candidates, target, index + 1, current, result);
    }
}