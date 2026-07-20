/*
Problem: Integer to Roman
Difficulty: Medium

Approach:

1. Store Roman numeral values and their corresponding symbols
   in descending order.
2. Traverse the values array.
3. While the current value is less than or equal to the number:
   - Append its Roman symbol to the result.
   - Subtract the value from the number.
4. Continue until the number becomes 0.
5. Return the constructed Roman numeral.

Time Complexity: O(1)
Space Complexity: O(1)
*/

class Solution {

    public String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4, 1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {

            while (num >= values[i]) {

                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }
}