/*
Problem: Remove Linked List Elements
Difficulty: Easy

Approach:
1. Create a dummy node pointing to head.
2. Traverse the list using a current pointer.
3. If current.next has the target value, skip that node.
4. Otherwise, move current forward.
5. Return dummy.next.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {

            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}