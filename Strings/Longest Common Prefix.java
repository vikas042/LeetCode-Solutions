/*
Problem: Longest Common Prefix
Difficulty: Easy

Approach:
Start with the first string as the prefix.
Compare the prefix with each remaining string.
If a string does not start with the current prefix,
reduce the prefix by removing its last character until it matches.

Time Complexity: O(N × M)
Space Complexity: O(1)

Where:
N = Number of strings
M = Length of the shortest string
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}