/*
Problem: Find the Index of the First Occurrence in a String
Difficulty: Easy

Approach:

1. Traverse the haystack from index 0 to
   (haystack.length() - needle.length()).
2. For each starting index, compare characters of
   needle with the corresponding characters in haystack.
3. If all characters match, return the current index.
4. If no match is found after checking all positions,
   return -1.

Time Complexity: O((n - m + 1) × m)
Space Complexity: O(1)
*/

class Solution {

    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}