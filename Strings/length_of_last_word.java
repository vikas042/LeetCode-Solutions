/*
Problem: Length of Last Word
Difficulty: Easy

Approach:

1. Start traversing the string from the last character.
2. Skip all trailing spaces.
3. Count the characters of the last word until
   a space or the beginning of the string is reached.
4. Return the count.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int lengthOfLastWord(String s) {

        int length = 0;
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}