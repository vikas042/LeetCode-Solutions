/*
Problem: Word Break
Difficulty: Medium

Approach:

1. Store all dictionary words in a HashSet.
2. Use a boolean dp array.
3. dp[i] means s.substring(0, i) can be segmented.
4. dp[0] = true because an empty string is valid.
5. For every position i, check all previous positions j.
6. If dp[j] is true and s.substring(j, i) exists
   in the dictionary, set dp[i] = true.
7. Return dp[n].

Time Complexity: O(n^2 * L)
Space Complexity: O(n + D)
*/

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}