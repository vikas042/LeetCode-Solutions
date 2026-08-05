/*
Problem: Reverse Linked List
Difficulty: Easy

Approach:

1. Initialize three pointers:
   - prev = null
   - curr = head
   - next = null
2. Traverse the linked list:
   - Store curr.next in next.
   - Reverse the link by pointing curr.next to prev.
   - Move prev to curr.
   - Move curr to next.
3. When traversal ends, prev points to the new head.
4. Return prev.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}