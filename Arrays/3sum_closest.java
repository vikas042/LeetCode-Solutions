/*
Problem: 3Sum Closest
Difficulty: Medium

Approach:
1. Sort the array.
2. Fix one element at a time.
3. Use two pointers (left and right) to find the sum
   closest to the target.
4. Update the closest sum whenever a better answer is found.
5. If the current sum is smaller than the target, move left
   pointer forward to increase the sum.
6. If the current sum is greater than the target, move right
   pointer backward to decrease the sum.
7. If the sum equals the target, return immediately since it
   is the closest possible answer.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    left++;
                }
                else if (sum > target) {
                    right--;
                }
                else {
                    return sum;
                }
            }
        }

        return closest;
    }
}

