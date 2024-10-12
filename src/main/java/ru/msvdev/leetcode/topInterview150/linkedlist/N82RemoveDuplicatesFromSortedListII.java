package ru.msvdev.leetcode.topInterview150.linkedlist;

/**
 * 82. Remove Duplicates from Sorted List II
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only
 * distinct numbers from the original list. Return the linked list sorted as well.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * <p>
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 * <p>
 * Constraints:
 * -- The number of nodes in the list is in the range [0, 300].
 * -- -100 <= Node.val <= 100
 * -- The list is guaranteed to be sorted in ascending order.
 */
public class N82RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        final ListNode preHead = new ListNode();
        ListNode node1 = preHead, node2 = head;

        while (node2 != null && node2.next != null) {
            final ListNode node3 = node2.next;

            if (node2.val != node3.val) {
                node1.next = node2;
                node1 = node2;
                node2 = node3;

            } else {
                final int valueToRemove = node2.val;
                while (node2 != null && node2.val == valueToRemove) {
                    node2 = node2.next;
                }
            }
        }

        node1.next = node2;

        return preHead.next;
    }


}
