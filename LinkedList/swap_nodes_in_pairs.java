/*
Problem: Swap Nodes in Pairs
Difficulty: Medium

Approach:

1. Create a dummy node before the head.
2. Use a pointer 'prev' starting from the dummy node.
3. While there are at least two nodes to swap:
      - Let first = prev.next
      - Let second = first.next
      - Adjust pointers to swap the two nodes.
      - Move prev to the end of the swapped pair.
4. Return dummy.next.

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

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {

            ListNode first = prev.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}