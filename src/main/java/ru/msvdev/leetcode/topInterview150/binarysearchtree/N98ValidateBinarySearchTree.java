package ru.msvdev.leetcode.topInterview150.binarysearchtree;

import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * -- The left subtree of a node contains only nodes with keys less than the node's key.
 * -- The right subtree of a node contains only nodes with keys greater than the node's key.
 * -- Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [1, 1e4].
 * -- -2^31 <= Node.val <= 2^31 - 1
 */
public class N98ValidateBinarySearchTree {

    private long previousValue = Long.MIN_VALUE;
    private boolean notValid = false;

    public boolean isValidBST(TreeNode root) {
        if (root == null || notValid) return !notValid;

        isValidBST(root.left);
        if (root.val <= previousValue) notValid = true;
        previousValue = root.val;
        isValidBST(root.right);

        return !notValid;
    }
}
