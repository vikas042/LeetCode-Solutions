/*
Problem: Median of Two Sorted Arrays
Difficulty: Hard

Approach:
1. Always perform binary search on the smaller array.
2. Partition both arrays such that the left half contains half of the elements.
3. Ensure:
   left1 <= right2
   left2 <= right1
4. If the partition is correct:
   - For odd total length, return the maximum of the left elements.
   - For even total length, return the average of the middle two elements.
5. Otherwise, adjust the binary search.

Time Complexity: O(log(min(m, n)))
Space Complexity: O(1)
*/

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {

                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;

            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}