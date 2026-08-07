/*
Problem: Remove Duplicates from Sorted List II
Difficulty: Medium

Approach:

1. Create a dummy node pointing to the head.
2. Use a pointer (prev) to build the resulting list.
3. Traverse the list:
   - If the current node has duplicates, skip all nodes
     with the same value.
   - Otherwise, move prev forward.
4. Return dummy.next.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null) {

            if (head.next != null && head.val == head.next.val) {

                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                prev.next = head.next;
            }

            else {
                prev = prev.next;
            }

            head = head.next;
        }

        return dummy.next;
    }
}