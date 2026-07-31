/*
Problem: Multiply Strings
Difficulty: Medium

Approach:

1. If either number is "0", return "0".
2. Create an integer array of size m + n to store intermediate results.
3. Multiply each digit of num1 with each digit of num2 from right to left.
4. Store the product at the correct position, handling carry.
5. Skip leading zeros and build the final answer using StringBuilder.

Time Complexity: O(m × n)
Space Complexity: O(m + n)
*/

class Solution {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + result[p2];

                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int num : result) {
            if (!(ans.length() == 0 && num == 0)) {
                ans.append(num);
            }
        }

        return ans.toString();
    }
}