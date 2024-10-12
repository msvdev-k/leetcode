package ru.msvdev.leetcode.topInterview150.linkedlist;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Constraints:
 * -- The number of nodes in the list is sz.
 * -- 1 <= sz <= 30
 * -- 0 <= Node.val <= 100
 * -- 1 <= n <= sz
 * <p>
 * Follow up: Could you do this in one pass?
 */
public class N19RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode end = head;

        while (n >= 0 && end != null) {
            end = end.next;
            n--;
        }

        if (end == null && n >= 0) return head.next;

        ListNode nextToRemove = head;
        while (end != null) {
            nextToRemove = nextToRemove.next;
            end = end.next;
        }

        if (nextToRemove.next != null) {
            nextToRemove.next = nextToRemove.next.next;
        }

        return head;
    }
}
