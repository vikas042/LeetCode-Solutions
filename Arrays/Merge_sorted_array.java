/*
Problem: Merge Sorted Array
Difficulty: Easy

Approach:

1. Use three pointers:
   - i points to the last valid element in nums1.
   - j points to the last element in nums2.
   - k points to the last position of nums1.
2. Compare nums1[i] and nums2[j]:
   - Place the larger element at nums1[k].
   - Move the corresponding pointer backward.
3. Continue until one array is exhausted.
4. If elements remain in nums2, copy them into nums1.
5. No need to copy remaining elements from nums1 since
   they are already in the correct position.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
} 
    

