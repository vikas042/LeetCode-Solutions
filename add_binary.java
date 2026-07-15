/*
Problem: Add Binary
Difficulty: Easy

Approach:

1. Initialize two pointers at the end of both strings.
2. Maintain a carry variable.
3. Traverse while either string has remaining digits
   or carry is non-zero.
4. Add the current bits and the carry.
5. Append (sum % 2) to the result.
6. Update carry as (sum / 2).
7. Reverse the StringBuilder and return the result.

Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))
*/

class Solution {

    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}