package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * <p>
 * Given a binary tree:
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer
 * to point to its next right node, just like in Figure B. The serialized output is in level order
 * as connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [0, 6000].
 * -- -100 <= Node.val <= 100
 * <p>
 * Follow-up:
 * -- You may only use constant extra space.
 * -- The recursive approach is fine. You may assume implicit stack space does not count as extra space
 * for this problem.
 */
public class N117PopulatingNextRightPointersInEachNodeII {

    public Node connect1(Node root) {
        if (root == null) return null;

        Node current = root;
        Node firstInNextLayer = null;
        Node lastInNextLayer = null;

        do {
            if (current.left != null) {
                if (firstInNextLayer == null) firstInNextLayer = current.left;
                if (lastInNextLayer != null) lastInNextLayer.next = current.left;
                lastInNextLayer = current.left;
            }

            if (current.right != null) {
                if (firstInNextLayer == null) firstInNextLayer = current.right;
                if (lastInNextLayer != null) lastInNextLayer.next = current.right;
                lastInNextLayer = current.right;
            }

            current = current.next;

        } while (current != null);

        connect1(firstInNextLayer);

        return root;
    }


    public Node connect2(Node root) {
        if (root == null) return null;

        Node current = root;
        do {
            Node firstInNextLayer = null;
            Node lastInNextLayer = null;

            do {
                if (current.left != null) {
                    if (firstInNextLayer == null) firstInNextLayer = current.left;
                    if (lastInNextLayer != null) lastInNextLayer.next = current.left;
                    lastInNextLayer = current.left;
                }

                if (current.right != null) {
                    if (firstInNextLayer == null) firstInNextLayer = current.right;
                    if (lastInNextLayer != null) lastInNextLayer.next = current.right;
                    lastInNextLayer = current.right;
                }

                current = current.next;

            } while (current != null);

            current = firstInNextLayer;

        } while (current != null);

        return root;
    }
}
