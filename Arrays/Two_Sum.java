/*
Problem: Two Sum
Difficulty: Easy

Approach:
Use a HashMap to store the numbers and their indices.
For each element, calculate the complement (target - current element).
If the complement exists in the HashMap, return the indices.
Otherwise, store the current element and its index.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
