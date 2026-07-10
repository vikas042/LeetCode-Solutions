/*
Problem: Roman to Integer
Difficulty: Easy

Approach:

1. Store the value of each Roman numeral in a HashMap.
2. Traverse the string from left to right.
3. For each character:
   - If its value is less than the value of the next character,
     subtract it from the result.
   - Otherwise, add it to the result.
4. Return the final integer value.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.HashMap;

class Solution {

    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int current = map.get(s.charAt(i));

            if (i < s.length() - 1 &&
                current < map.get(s.charAt(i + 1))) {

                result -= current;
            } else {
                result += current;
            }
        }

        return result;
    }
} 
