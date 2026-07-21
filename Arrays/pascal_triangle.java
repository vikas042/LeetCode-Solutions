/*
Problem: Pascal's Triangle
Difficulty: Easy

Approach:

1. Create an empty result list.
2. Generate each row from 0 to numRows - 1.
3. The first and last element of every row is 1.
4. For middle elements, use:
      currentRow[j] = previousRow[j - 1] + previousRow[j]
5. Add each completed row to the result.
6. Return the final triangle.

Time Complexity: O(numRows²)
Space Complexity: O(numRows²)
*/

class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    row.add(1);
                }

                else {
                    row.add(result.get(i - 1).get(j - 1)
                           + result.get(i - 1).get(j));
                }
            }

            result.add(row);
        }

        return result;
    }
}