public /*
Problem: Valid Sudoku
Difficulty: Medium

Approach:

1. Use a HashSet to keep track of the digits that have
   already appeared in each row, column, and 3×3 sub-box.
2. Traverse every cell of the Sudoku board.
3. Ignore empty cells ('.').
4. For each digit, create three unique keys:
   - Row key
   - Column key
   - Box key
5. If any key already exists in the HashSet, the board
   is invalid, so return false.
6. Otherwise, add all three keys to the HashSet.
7. If the entire board is traversed without duplicates,
   return true.

Time Complexity: O(81) ≈ O(1)
Space Complexity: O(81) ≈ O(1)
*/

import java.util.HashSet;

class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char current = board[row][col];

                if (current == '.') {
                    continue;
                }

                String rowKey = current + " in row " + row;
                String colKey = current + " in col " + col;
                String boxKey = current + " in box " + (row / 3) + "-" + (col / 3);

                if (set.contains(rowKey) ||
                    set.contains(colKey) ||
                    set.contains(boxKey)) {
                    return false;
                }

                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }

        return true;
    }
} {
    
}
