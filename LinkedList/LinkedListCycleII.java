/*
Problem: Linked List Cycle II
Difficulty: Medium

Approach:

1. Use Floyd's Cycle Detection Algorithm:
   - Move slow pointer one step.
   - Move fast pointer two steps.
2. If slow and fast meet, a cycle exists.
3. Move one pointer to the head.
4. Move both pointers one step at a time.
5. The node where they meet again is the start of the cycle.
6. If no cycle exists, return null.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                ListNode start = head;

                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }

                return start;
            }
        }

        return null;
    }
}