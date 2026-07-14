/*
Problem: Longest Substring Without Repeating Characters
Difficulty: Medium

Approach:

1. Use the Sliding Window technique with two pointers:
   - left: Start of the current window.
   - right: End of the current window.
2. Use a HashSet to store the characters currently
   in the window.
3. Expand the window by moving the right pointer.
4. If a duplicate character is found:
   - Remove characters from the left side until
     the duplicate is removed.
5. Update the maximum length after each expansion.
6. Return the maximum length.

Time Complexity: O(n)
Space Complexity: O(min(n, m))
where m is the size of the character set.
*/

import java.util.HashSet;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}