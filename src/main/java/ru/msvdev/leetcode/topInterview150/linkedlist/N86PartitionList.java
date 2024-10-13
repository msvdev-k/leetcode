package ru.msvdev.leetcode.topInterview150.linkedlist;

/**
 * 86. Partition List
 * <p>
 * Given the head of a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * <p>
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 * <p>
 * Constraints:
 * -- The number of nodes in the list is in the range [0, 200].
 * -- -100 <= Node.val <= 100
 * -- -200 <= x <= 200
 */
public class N86PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        final ListNode less = new ListNode();
        final ListNode greater = new ListNode();

        ListNode lessPtx = less;
        ListNode greaterPtx = greater;

        while (head != null) {
            if (head.val < x) {
                lessPtx.next = head;
                lessPtx = head;
            } else {
                greaterPtx.next = head;
                greaterPtx = head;
            }
            head = head.next;
        }

        greaterPtx.next = null;

        if (less.next == null) return greater.next;
        lessPtx.next = greater.next;

        return less.next;
    }
}
