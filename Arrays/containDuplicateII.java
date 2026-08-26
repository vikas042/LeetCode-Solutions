/*
Problem: Contains Duplicate II
Difficulty: Easy

Approach:

1. Use a HashMap to store each number's latest index.
2. Traverse the array.
3. If the number already exists:
   - Calculate the distance between the current
     index and its previous index.
   - If the distance is <= k, return true.
4. Update the number's index.
5. If no valid pair is found, return false.

Time Complexity: O(n) average
Space Complexity: O(n)
*/

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (map.containsKey(num)) {

                int previousIndex = map.get(num);

                if (i - previousIndex <= k) {
                    return true;
                }
            }

         
            map.put(num, i);
        }

        return false;
    }
}