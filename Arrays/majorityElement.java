/*
Problem: Contains Duplicate
Difficulty: Easy

Approach:

1. Use a HashSet to store visited elements.
2. Traverse the array.
3. If an element already exists in the set,
   return true.
4. Otherwise, add it to the set.
5. If no duplicate is found, return false.

Time Complexity: O(n) average
Space Complexity: O(n)
*/

class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {
                return true;
            }

            // Store the number
            set.add(num);
        }

        return false;
    }
}