/*
Problem: Reverse Nodes in k-Group
Difficulty: Hard

Approach:
1. Use a dummy node before the head.
2. Find the kth node from the current group.
3. If fewer than k nodes remain, stop.
4. Reverse the current group.
5. Connect the reversed group with the previous and next groups.
6. Repeat until the list is completely processed.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = getKthNode(groupPrev, k);

            // Less than k nodes remaining
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // Reverse the group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous part to reversed group
            ListNode oldGroupStart = groupPrev.next;

            groupPrev.next = kth;

            // Move groupPrev to the end of reversed group
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {

        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }
}