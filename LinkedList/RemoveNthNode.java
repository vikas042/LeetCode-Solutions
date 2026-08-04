/*
Problem: Remove Nth Node From End of List
Difficulty: Medium

Approach:

1. Create a dummy node pointing to the head.
2. Initialize two pointers: fast and slow at the dummy node.
3. Move the fast pointer n + 1 steps ahead.
4. Move both pointers together until fast reaches the end.
5. The slow pointer will be just before the node to remove.
6. Skip the target node by updating the next pointer.
7. Return dummy.next as the new head.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {

            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}