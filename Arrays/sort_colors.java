/*
Problem: Sort Colors
Difficulty: Medium

Approach:

1. Use three pointers: low, mid, and high.
2. 0 belongs to the left side.
3. 1 belongs to the middle.
4. 2 belongs to the right side.
5. Swap elements to put them in their correct regions.
6. Do everything in-place without using a sorting function.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {

                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            }

            else if (nums[mid] == 1) {

                mid++;
            }

            else {

                // Swap 2 to the right
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;

                high--;

            }
        }
    }
}