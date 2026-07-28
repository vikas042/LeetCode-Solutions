/*
Problem: Merge Two Sorted Lists
Difficulty: Easy

Approach:

1. Create a dummy node to act as the start of the merged list.
2. Use a pointer 'current' to build the merged list.
3. Compare the current nodes of both lists.
4. Attach the smaller node to the merged list and move that list's pointer.
5. Move 'current' forward.
6. After one list is exhausted, attach the remaining nodes
   from the other list.
7. Return dummy.next as the head of the merged list.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
}