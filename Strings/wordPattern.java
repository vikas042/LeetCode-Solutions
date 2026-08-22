/*
Problem: Word Pattern
Difficulty: Easy

Approach:

1. Split the string into words.
2. Use HashMap to store character -> word mapping.
3. Use HashSet to ensure that each word maps to
   only one character.
4. If an existing mapping does not match, return false.
5. If a word is already used by another character,
   return false.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        // Number of characters and words must be equal
        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(ch)) {

                if (!map.get(ch).equals(word)) {
                    return false;
                }
            }

            else {

                if (usedWords.contains(word)) {
                    return false;
                }

                map.put(ch, word);
                usedWords.add(word);
            }
        }

        return true;
    }
}