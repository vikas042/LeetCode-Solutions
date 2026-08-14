/*
Problem: Triangle
Difficulty: Medium

Approach:

1. Start with the bottom row of the triangle.
2. Store the bottom row in a 1D dp array.
3. Move from the second-last row toward the top.
4. For each element, choose the minimum of the
   two adjacent elements from the row below.
5. Add the current element to that minimum.
6. At the end, dp[0] contains the minimum path sum.

Time Complexity: O(n^2)
Space Complexity: O(n)
*/

class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[] dp = new int[n];

        
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {

                dp[j] = triangle.get(i).get(j)
                        + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}