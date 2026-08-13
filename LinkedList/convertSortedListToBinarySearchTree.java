/*
Problem: Convert Sorted List to Binary Search Tree
Difficulty: Medium

Approach:

1. Find the middle node using slow and fast pointers.
2. Make the middle node the root.
3. Recursively create the left subtree from the left half.
4. Recursively create the right subtree from the right half.
5. Continue until the list becomes empty.

Time Complexity: O(n log n)
Space Complexity: O(log n)
*/

class Solution {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        TreeNode root = new TreeNode(slow.val);

        root.left = sortedListToBST(head);

     
        root.right = sortedListToBST(slow.next);

        return root;
    }
}