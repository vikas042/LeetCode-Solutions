/*
Problem: Regular Expression Matching
Difficulty: Hard

Approach:

1. Create a DP table where dp[i][j] indicates whether
   the first i characters of s match the first j
   characters of p.
2. Initialize dp[0][0] = true.
3. Handle patterns like "a*", "a*b*", etc. that can
   match an empty string.
4. Traverse the DP table:
      - If current characters match or pattern has '.',
        copy the previous diagonal value.
      - If pattern has '*':
          a) Ignore the previous character:
                dp[i][j] = dp[i][j - 2]
          b) Use '*' to match one or more characters
             if preceding character matches:
                dp[i][j] |= dp[i - 1][j]
5. Return dp[m][n].

Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/

class Solution {

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else if (pc == '*') {

                    dp[i][j] = dp[i][j - 2];

                    char prev = p.charAt(j - 2);

                    if (prev == '.' || prev == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }
}