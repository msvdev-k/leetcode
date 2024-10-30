package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 101. Symmetric Tree
 * <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around
 * its center).
 * <p>
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [1, 1000].
 * -- -100 <= Node.val <= 100
 * <p>
 * Follow up: Could you solve it both recursively and iteratively?
 */
public class N101SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricEquals(root.left, root.right);
    }

    private boolean isSymmetricEquals(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricEquals(left.left, right.right) && isSymmetricEquals(left.right, right.left);
    }

}
