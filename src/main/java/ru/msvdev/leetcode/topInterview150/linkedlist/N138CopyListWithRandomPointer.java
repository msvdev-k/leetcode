package ru.msvdev.leetcode.topInterview150.linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such
 * that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for
 * the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented
 * as a pair of [val, random_index] where:
 * -- val: an integer representing Node.val
 * -- random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * <p>
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * <p>
 * Constraints:
 * -- 0 <= n <= 1000
 * -- -10^4 <= Node.val <= 10^4
 * -- Node.random is null or is pointing to some node in the linked list.
 */
public class N138CopyListWithRandomPointer {

    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            final Node newNode = new Node(head.val);
            if (head == head.random) {
                newNode.random = newNode;
            }
            return newNode;
        }

        List<Node> newNodesList = new ArrayList<>();
        Map<Node, Integer> oldIndexMap = new HashMap<>();

        final Node newHead = new Node(0);

        var currentOldNode = head;
        var currentNewNode = newHead;
        int idx = 0;
        while (currentOldNode != null) {
            oldIndexMap.put(currentOldNode, idx);

            var newNode = new Node(currentOldNode.val);
            newNodesList.add(newNode);
            currentNewNode.next = newNode;
            currentNewNode = newNode;

            currentOldNode = currentOldNode.next;
            idx++;
        }

        currentOldNode = head;
        idx = 0;
        while (currentOldNode != null) {
            var randomNode = currentOldNode.random;
            if (randomNode != null) {
                newNodesList.get(idx).random = newNodesList.get(oldIndexMap.get(randomNode));
            }

            currentOldNode = currentOldNode.next;
            idx++;
        }


        return newHead.next;
    }


    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        if (head.next == null) {
            final Node newNode = new Node(head.val);
            if (head == head.random) {
                newNode.random = newNode;
            }
            return newNode;
        }

        final Map<Node, Node> oldNewMap = new HashMap<>();
        final Node newHead = new Node(0);

        var currentOldNode = head;
        var currentNewNode = newHead;
        while (currentOldNode != null) {
            final var newNode = new Node(currentOldNode.val);
            oldNewMap.put(currentOldNode, newNode);
            currentNewNode.next = newNode;
            currentNewNode = newNode;
            currentOldNode = currentOldNode.next;
        }

        currentOldNode = head;
        while (currentOldNode != null) {
            var randomNode = currentOldNode.random;
            if (randomNode != null) {
                oldNewMap.get(currentOldNode).random = oldNewMap.get(randomNode);
            }
            currentOldNode = currentOldNode.next;
        }

        return newHead.next;
    }


    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
