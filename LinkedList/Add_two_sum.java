/*
Problem: Add Two Numbers
Difficulty: Medium

Approach:
Use a dummy node to build the result linked list.
Traverse both linked lists simultaneously while maintaining a carry.
Add corresponding digits and create new nodes for the result.

Time Complexity: O(max(m, n))
Space Complexity: O(max(m, n))

Where:
m = length of l1
n = length of l2
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}