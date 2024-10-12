package ru.msvdev.leetcode.topInterview150.linkedlist;

/**
 * 61. Rotate List
 * <p>
 * Given the head of a linked list, rotate the list to the right by k places.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * <p>
 * Example 2:
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 * <p>
 * Constraints:
 * -- The number of nodes in the list is in the range [0, 500].
 * -- -100 <= Node.val <= 100
 * -- 0 <= k <= 2e9
 */
public class N61RotateList {

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }
        final int shift = k % n;
        if (shift == 0) return head;

        ListNode end = head;
        for (int i = 0; i < shift; i++) {
            end = end.next;
        }

        ListNode first = head;
        while (end.next != null) {
            first = first.next;
            end = end.next;
        }

        end.next = head;
        head = first.next;
        first.next = null;

        return head;
    }


    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int n = 1;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
            n++;
        }
        final int shift = k % n;
        if (shift == 0) return head;

        ListNode kThNode = head;
        for (int i = n - 1; i > shift; i--) {
            kThNode = kThNode.next;
        }

        end.next = head;
        head = kThNode.next;
        kThNode.next = null;

        return head;
    }
}
