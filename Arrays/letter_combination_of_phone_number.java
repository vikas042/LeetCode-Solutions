/*
Problem: Letter Combinations of a Phone Number
Difficulty: Medium

Approach:

1. Create a mapping of digits (2-9) to their corresponding letters.
2. If the input string is empty, return an empty list.
3. Use backtracking to generate all possible combinations.
4. For each digit, try every possible letter.
5. When a combination reaches the length of the input string,
   add it to the result.
6. Backtrack by removing the last added letter.

Time Complexity: O(4^n)
Space Complexity: O(n)
*/

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), result, map);

        return result;
    }

    private void backtrack(String digits,
                           int index,
                           StringBuilder current,
                           List<String> result,
                           String[] map) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            current.append(ch);

            backtrack(digits, index + 1, current, result, map);

            current.deleteCharAt(current.length() - 1);
        }
    }
}