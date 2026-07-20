/*
Problem: String to Integer (atoi)
Difficulty: Medium

Approach:

1. Skip leading whitespace.
2. Determine the sign (+ or -).
3. Read digits until a non-digit is encountered.
4. Before adding a digit, check for integer overflow.
5. If overflow occurs:
   - Return Integer.MAX_VALUE for positive numbers.
   - Return Integer.MIN_VALUE for negative numbers.
6. Return the final signed integer.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Handle empty string after spaces
        if (i == n) {
            return 0;
        }

        // Determine sign
        int sign = 1;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        int result = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 &&
                 digit > Integer.MAX_VALUE % 10)) {

                return sign == 1
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }
}