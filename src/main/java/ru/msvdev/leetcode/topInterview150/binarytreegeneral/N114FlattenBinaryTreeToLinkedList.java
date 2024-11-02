package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 114. Flatten Binary Tree to Linked List
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * -- The "linked list" should use the same TreeNode class where the right child pointer points
 * to the next node in the list and the left child pointer is always null.
 * -- The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * Example 1:
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * Example 2:
 * Input: root = []
 * Output: []
 * <p>
 * Example 3:
 * Input: root = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [0, 2000].
 * -- -100 <= Node.val <= 100
 * <p>
 * Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
public class N114FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenRecursive(root);
    }

    private TreeNode flattenRecursive(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;

        if (left != null) {
            TreeNode lastLeftNode = flattenRecursive(left);
            node.left = null;
            node.right = left;

            if (right != null) {
                lastLeftNode.right = right;
                return flattenRecursive(right);
            }

            return lastLeftNode;
        }

        if (right != null) {
            return flattenRecursive(right);
        }

        return node;
    }
}
