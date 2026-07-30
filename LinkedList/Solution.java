/*
Problem: Linked List Cycle
Difficulty: Easy

Approach:

1. Initialize two pointers:
      - slow = head
      - fast = head
2. Move:
      - slow by one step.
      - fast by two steps.
3. If slow and fast meet, a cycle exists.
4. If fast reaches null or fast.next reaches null,
   there is no cycle.
5. Return the result.

Time Complexity: O(n)
Space Complexity: O(1)
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}