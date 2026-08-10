/*
Problem: Decode Ways
Difficulty: Medium

Approach:

1. If the string starts with '0', return 0.
2. A single digit from '1' to '9' can be decoded.
3. Two digits from '10' to '26' can be decoded together.
4. Keep track of the previous two DP values.
5. Return the total number of decoding ways.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int numDecodings(String s) {

        int n = s.length();

        // If string starts with 0, it is invalid
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 1; i < n; i++) {

            int current = 0;

            // Single digit
            if (s.charAt(i) != '0') {
                current += prev1;
            }

            // Two digits
            int twoDigit = Integer.parseInt(
                s.substring(i - 1, i + 1)
            );

            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}