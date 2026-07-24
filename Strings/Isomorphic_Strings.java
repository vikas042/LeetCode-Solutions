/*
Problem: Isomorphic Strings
Difficulty: Easy

Approach:

1. If the lengths of the strings are different,
   return false.
2. Use two HashMaps:
      - One to map characters from s to t.
      - Another to map characters from t to s.
3. Traverse both strings simultaneously.
4. If a mapping already exists, verify it is consistent.
5. Otherwise, create the new mappings.
6. If any mapping conflicts, return false.
7. If all characters are processed successfully,
   return true.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mapST.containsKey(chS)) {

                if (mapST.get(chS) != chT) {
                    return false;
                }

            } else {

                mapST.put(chS, chT);
            }

            if (mapTS.containsKey(chT)) {

                if (mapTS.get(chT) != chS) {
                    return false;
                }

            } else {

                mapTS.put(chT, chS);
            }
        }

        return true;
    }
}