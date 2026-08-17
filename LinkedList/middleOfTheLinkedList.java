/*
Problem: Middle of the Linked List
Difficulty: Easy

Approach:

1. Use two pointers: slow and fast.
2. slow moves one step at a time.
3. fast moves two steps at a time.
4. When fast reaches the end, slow is at the middle.
5. For an even-length list, slow automatically points
   to the second middle node.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}