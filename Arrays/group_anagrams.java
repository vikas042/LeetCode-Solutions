/*
Problem: Group Anagrams
Difficulty: Medium

Approach:

1. Create a HashMap where:
      - Key = Sorted version of the string.
      - Value = List of all anagrams.
2. Traverse each string in the input array.
3. Convert the string into a character array.
4. Sort the character array.
5. Convert it back into a string to use as the key.
6. Add the original string to the corresponding list.
7. Return all the values of the HashMap.

Time Complexity: O(n × k log k)
Space Complexity: O(n × k)
*/

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}