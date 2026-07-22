/*
Problem: Permutations II
Difficulty: Medium

Approach:

1. Sort the input array to group duplicate elements together.
2. Use backtracking to generate all permutations.
3. Maintain a boolean visited[] array to track used elements.
4. Skip duplicate elements by checking:
      if (i > 0 &&
          nums[i] == nums[i - 1] &&
          !visited[i - 1])
      continue;
5. Add a permutation when its size equals nums.length.
6. Backtrack by removing the last element and marking it unused.

Time Complexity: O(n × n!)
Space Complexity: O(n)
*/

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, visited, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums,
                           boolean[] visited,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (i > 0 &&
                nums[i] == nums[i - 1] &&
                !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            current.add(nums[i]);

            backtrack(nums, visited, current, result);

            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}