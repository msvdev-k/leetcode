package ru.msvdev.leetcode.topInterview150.linkedlist;

/**
 * 141. Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by
 * continuously following the next pointer. Internally, pos is used to denote the index of the node
 * that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * -- The number of the nodes in the list is in the range [0, 10^4].
 * -- -10^5 <= Node.val <= 10^5
 * -- pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class N141LinkedListCycle {

    /**
     * Алгоритм Флойда поиска цикла (черепаха и заяц)
     * Поиск до совпадения x_i == x_2i
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) return false;

        ListNode tortoise = head;
        ListNode hare = head;
        do {
            hare = hare.next;
            if (hare == null) return false;
            hare = hare.next;
            if (hare == null) return false;

            tortoise = tortoise.next;

        } while (!tortoise.equals(hare));

        return true;
    }


    /**
     * Алгоритм Флойда поиска цикла (черепаха и заяц)
     * Поиск до совпадения x_i == x_2i
     */
    public boolean hasCycle2(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                return true;
            }
        }

        return false;
    }


    /**
     * Алгоритм Брента поиска цикла
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode tortoise = head;
        ListNode hare = head.next;

        int power = 1, lambda = 1;

        while (hare != tortoise) {
            if (power == lambda) {
                tortoise = hare;
                power *= 2;
                lambda = 0;
            }

            hare = hare.next;
            lambda++;
            if (hare == null) return false;
        }

        return true;
    }

}
