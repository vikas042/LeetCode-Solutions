/*
Problem: Rotate List
Difficulty: Medium

Approach:

1. If the list is empty, has one node, or k is 0,
   return the head.
2. Find the length of the linked list and the last node.
3. Compute k = k % length.
4. If k becomes 0, return the head.
5. Connect the last node to the head to form a circular list.
6. Move (length - k - 1) steps from the head
   to reach the new tail.
7. The next node becomes the new head.
8. Break the circle and return the new head.

Time Complexity: O(n)
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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;

        if (k == 0) {
            return head;
        }

        tail.next = head;

        int steps = length - k - 1;
        ListNode newTail = head;

        while (steps-- > 0) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}