/*
Problem: Zigzag Conversion
Difficulty: Medium

Approach:

1. If numRows is 1 or greater than or equal to the
   string length, return the original string.
2. Create a StringBuilder for each row.
3. Traverse the string character by character.
4. Add each character to the current row.
5. Change direction when reaching the first or last row:
   - Move downward until the last row.
   - Then move upward diagonally.
6. Concatenate all rows to form the final result.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char ch : s.toCharArray()) {

            rows.get(currentRow).append(ch);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            if (goingDown) {
                currentRow++;
            } else {
                currentRow--;
            }
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}