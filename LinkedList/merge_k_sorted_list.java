/*
Problem: Merge k Sorted Lists
Difficulty: Hard

Approach:

1. Use a PriorityQueue (Min Heap) to always select the
   smallest node among the heads of all linked lists.
2. Insert the head of each non-null linked list into the heap.
3. Create a dummy node to build the merged list.
4. While the heap is not empty:
   - Remove the smallest node.
   - Attach it to the merged list.
   - If the removed node has a next node,
     insert it into the heap.
5. Return dummy.next as the head of the merged list.

Time Complexity: O(N log k)
Space Complexity: O(k)

where:
N = Total number of nodes
k = Number of linked lists
*/

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
                new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {

            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            tail.next = node;
            tail = tail.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}