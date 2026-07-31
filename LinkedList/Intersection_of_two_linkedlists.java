/*
Problem: Intersection of Two Linked Lists
Difficulty: Easy

Approach:

1. Initialize two pointers:
      - pointerA = headA
      - pointerB = headB
2. Traverse both lists.
3. When pointerA reaches the end,
   move it to headB.
4. When pointerB reaches the end,
   move it to headA.
5. Eventually:
      - They meet at the intersection node, or
      - Both become null if there is no intersection.
6. Return the meeting node.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {

            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }
}