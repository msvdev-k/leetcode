package ru.msvdev.leetcode.topInterview150.linkedlist;

/**
 * 25. Reverse Nodes in k-Group
 * <p>
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
 * is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * <p>
 * Constraints:
 * -- The number of nodes in the list is n.
 * -- 1 <= k <= n <= 5000
 * -- 0 <= Node.val <= 1000
 * <p>
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 */
public class N25ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        int n = 1;
        ListNode node = head;
        while (node.next != null && node.next.next != null) {
            node = node.next.next;
            n += 2;
        }
        if (node.next != null) n++;

        final int kGroup = n / k;

        ListNode prefix = null;
        ListNode first = head;

        for (int group = 0; group < kGroup; group++) {
            ListNode second = first;
            ListNode postfix = first.next;

            for (int i = 1; i < k; i++) {
                final var tmp = postfix;
                postfix = postfix.next;
                tmp.next = second;
                second = tmp;
            }

            first.next = postfix;

            if (prefix != null) {
                prefix.next = second;
            } else {
                head = second;
            }

            prefix = first;
            first = postfix;
        }

        return head;
    }
}
