/*
Problem: Sort List
Difficulty: Medium

Approach:
1. Find the middle of the linked list using slow and fast pointers.
2. Split the list into two halves.
3. Recursively sort both halves.
4. Merge the two sorted halves.
5. Return the merged list.

Time Complexity: O(n log n)
Space Complexity: O(log n) due to recursion.
*/

class Solution {

    public ListNode sortList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list
        ListNode second = slow.next;
        slow.next = null;

        // Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(second);

        // Merge sorted halves
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        // Add remaining nodes
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }
}