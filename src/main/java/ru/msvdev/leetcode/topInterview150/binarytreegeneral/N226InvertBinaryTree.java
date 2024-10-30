package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 226. Invert Binary Tree
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * <p>
 * Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [0, 100].
 * -- -100 <= Node.val <= 100
 */
public class N226InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);

        return root;
    }
}
