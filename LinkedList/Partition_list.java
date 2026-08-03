/*
Problem: Partition List
Difficulty: Medium

Approach:

1. Create two dummy linked lists:
   - One for nodes with values less than x.
   - One for nodes with values greater than or equal to x.
2. Traverse the original linked list:
   - Append each node to the appropriate list.
3. Connect the end of the smaller list to the beginning of
   the greater/equal list.
4. Set the end of the greater/equal list to null to avoid cycles.
5. Return the head of the merged list.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public ListNode partition(ListNode head, int x) {

        ListNode smallerDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode smaller = smallerDummy;
        ListNode greater = greaterDummy;

        while (head != null) {

            if (head.val < x) {

                smaller.next = head;
                smaller = smaller.next;
            }

            else {

                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        greater.next = null;
        smaller.next = greaterDummy.next;

        return smallerDummy.next;
    }
}