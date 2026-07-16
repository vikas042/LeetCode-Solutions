/*
Problem: Valid Palindrome
Difficulty: Easy

Approach:

1. Use two pointers:
   - left starts from the beginning.
   - right starts from the end.
2. Skip all non-alphanumeric characters.
3. Convert both characters to lowercase and compare them.
4. If they are different, return false.
5. Move both pointers inward.
6. If all characters match, return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right &&
                   !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}