/*
Problem: Generate Parentheses
Difficulty: Medium

Approach:

1. Use backtracking to generate all valid parentheses.
2. Keep track of:
      - open : number of '(' used
      - close: number of ')' used
3. Add '(' if open < n.
4. Add ')' if close < open.
5. When the current string length becomes 2 * n,
   add it to the result.
6. Backtrack to explore all possible valid combinations.

Time Complexity: O(4^n / √n)
Space Complexity: O(n)
*/

class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result,
                           StringBuilder current,
                           int open,
                           int close,
                           int n) {

        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}