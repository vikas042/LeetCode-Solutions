/*
Problem: Excel Sheet Column Title
Difficulty: Easy

Approach:

1. Use a StringBuilder to construct the column title.
2. While columnNumber is greater than 0:
   - Decrement columnNumber by 1 to convert
     from 1-based indexing to 0-based indexing.
   - Find the current character using:
       (columnNumber % 26) + 'A'
   - Append the character to the result.
   - Divide columnNumber by 26.
3. Reverse the StringBuilder and return the result.

Time Complexity: O(log26(n))
Space Complexity: O(log26(n))
*/

class Solution {

    public String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            char ch = (char) ('A' + (columnNumber % 26));
            result.append(ch);

            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}