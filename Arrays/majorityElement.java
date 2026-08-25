/*
Problem: Majority Element
Difficulty: Easy

Approach:

1. Use Boyer-Moore Voting Algorithm.
2. Maintain a candidate and its count.
3. If count becomes 0, select the current number
   as the new candidate.
4. Same number -> increase count.
5. Different number -> decrease count.
6. The final candidate is the majority element.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

          
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}