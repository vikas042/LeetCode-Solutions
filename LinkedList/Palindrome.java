/*
Problem: Palindrome Linked List
Difficulty: Easy

Approach:

1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second half of the list.
3. Compare the first half and the reversed second half.
4. If all values are equal, the list is a palindrome.
5. Otherwise, return false.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);

        ListNode firstHalf = head;
        ListNode current = secondHalf;

        while (current != null) {

            if (firstHalf.val != current.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            current = current.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}