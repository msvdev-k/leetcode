package ru.msvdev.leetcode.topInterview150.binarysearchtree;

import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;

/**
 * 530. Minimum Absolute Difference in BST
 * <p>
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between
 * the values of any two different nodes in the tree.
 * <p>
 * Example 1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * <p>
 * Example 2:
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [2, 1e4].
 * -- 0 <= Node.val <= 1e5
 */
public class N530MinimumAbsoluteDifferenceInBST {

    private int previousValue = Integer.MIN_VALUE / 2;
    private int minDifference = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return minDifference;

        getMinimumDifference(root.left);
        minDifference = Math.min(root.val - previousValue, minDifference);
        previousValue = root.val;
        getMinimumDifference(root.right);

        return minDifference;
    }
}
