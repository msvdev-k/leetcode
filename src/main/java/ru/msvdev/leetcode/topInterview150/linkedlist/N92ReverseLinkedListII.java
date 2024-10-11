package ru.msvdev.leetcode.topInterview150.linkedlist;

/**
 * 92. Reverse Linked List II
 * <p>
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * <p>
 * Example 2:
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * Constraints:
 * -- The number of nodes in the list is n.
 * -- 1 <= n <= 500
 * -- -500 <= Node.val <= 500
 * -- 1 <= left <= right <= n
 * <p>
 * Follow up: Could you do it in one pass?
 */
public class N92ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode prefix = null;
        ListNode first = head;

        for (int i = 1; i < left; i++) {
            prefix = first;
            first = first.next;
        }

        ListNode second = first;
        ListNode postfix = first.next;
        for (int i = left; i < right; i++) {
            final var tmp = postfix;
            postfix = postfix.next;
            tmp.next = second;
            second = tmp;
        }

        first.next = postfix;

        if (prefix == null) return second;
        prefix.next = second;

        return head;
    }
}
