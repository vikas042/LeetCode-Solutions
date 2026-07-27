/*
Problem: Subsets
Difficulty: Medium

Approach:

1. Use backtracking to generate all possible subsets.
2. Start with an empty subset.
3. At each recursive call:
      - Add the current subset to the result.
      - Iterate through the remaining elements.
      - Include the current element.
      - Recurse for the next index.
      - Backtrack by removing the last element.
4. Continue until all elements are processed.

Time Complexity: O(n × 2^n)
Space Complexity: O(n)
*/

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            current.add(nums[i]);

            backtrack(nums, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}