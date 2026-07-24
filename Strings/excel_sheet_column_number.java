/*
Problem: Excel Sheet Column Number
Difficulty: Easy

Approach:

1. Initialize the result as 0.
2. Traverse each character in the column title.
3. Convert the character to its corresponding value:
      value = character - 'A' + 1
4. Update the result using base-26 conversion:
      result = result * 26 + value
5. Return the final column number.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int titleToNumber(String columnTitle) {

        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            int value = columnTitle.charAt(i) - 'A' + 1;

            result = result * 26 + value;
        }

        return result;
    }
}