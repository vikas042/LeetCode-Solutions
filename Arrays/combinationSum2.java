/*
Problem: Combination Sum II
Difficulty: Medium

Approach:

1. Sort the candidates array to group duplicate elements.
2. Use Backtracking to generate all valid combinations.
3. If the target becomes 0:
   - Add the current combination to the result.
4. Iterate through the candidates starting from the current index.
5. Skip duplicate elements to avoid duplicate combinations.
6. If the current number exceeds the remaining target,
   stop the loop (since the array is sorted).
7. Choose the current number:
   - Add it to the current combination.
   - Recur with the next index because each number
     can be used only once.
8. Backtrack by removing the last added number.

Time Complexity: O(2^n)
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate elements
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Stop if the current number is greater than the target
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            backtrack(candidates,
                      target - candidates[i],
                      i + 1,
                      current,
                      result);

            current.remove(current.size() - 1);
        }
    }
}