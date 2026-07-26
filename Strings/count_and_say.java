/*
Problem: Count and Say
Difficulty: Medium

Approach:

1. Start with the first sequence as "1".
2. Repeat the process n - 1 times:
      - Traverse the current string.
      - Count consecutive identical digits.
      - Append the count followed by the digit
        to a StringBuilder.
      - Update the current string.
3. Return the final generated string.

Time Complexity: O(n × m)
Space Complexity: O(m)

where:
n = input number
m = length of the generated string
*/

class Solution {

    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder current = new StringBuilder();

            int count = 1;

            for (int j = 1; j <= result.length(); j++) {

                if (j < result.length() &&
                    result.charAt(j) == result.charAt(j - 1)) {

                    count++;

                } else {

                    current.append(count);
                    current.append(result.charAt(j - 1));

                    count = 1;
                }
            }

            result = current.toString();
        }

        return result;
    }
}