/*
Problem: Reverse Linked List II
Difficulty: Medium

Approach:

1. Create a dummy node pointing to the head.
2. Move a pointer (prev) to the node just before position 'left'.
3. Reverse the nodes from position 'left' to 'right'.
4. Reconnect the reversed sublist with the remaining list.
5. Return dummy.next as the new head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}