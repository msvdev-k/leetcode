package ru.msvdev.leetcode.topInterview150.linkedlist;

import java.util.Objects;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored
 * in reverse order, and each of their nodes contains a single digit. Add the two numbers and return
 * the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * Constraints:
 * -- The number of nodes in each linked list is in the range [1, 100].
 * -- 0 <= Node.val <= 9
 * -- It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class N2AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final var sumList = new ListNode();
        var currentPosition = sumList;

        int register = 0;
        do {
            if (l1 != null) {
                register += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                register += l2.val;
                l2 = l2.next;
            }

            currentPosition.next = new ListNode(register % 10);
            currentPosition = currentPosition.next;
            register /= 10;

        } while (l1 != null || l2 != null);

        if (register > 0) {
            currentPosition.next = new ListNode(register);
        }

        return sumList.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
