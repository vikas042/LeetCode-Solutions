/*
Problem: Convert Sorted Array to Binary Search Tree
Difficulty: Easy

Approach:

1. Use recursion to build the BST.
2. Select the middle element of the current subarray
   as the root to keep the tree height-balanced.
3. Recursively build the left subtree from the left half.
4. Recursively build the right subtree from the right half.
5. Return the constructed root node.

Time Complexity: O(n)
Space Complexity: O(log n)
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {

        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }
}