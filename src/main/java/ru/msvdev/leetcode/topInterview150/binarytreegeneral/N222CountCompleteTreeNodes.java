package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 222. Count Complete Tree Nodes
 * <p>
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete
 * binary tree, and all nodes in the last level are as far left as possible. It can have between
 * 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,6]
 * Output: 6
 * <p>
 * Example 2:
 * Input: root = []
 * Output: 0
 * <p>
 * Example 3:
 * Input: root = [1]
 * Output: 1
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [0, 5e4].
 * -- 0 <= Node.val <= 5e4
 * -- The tree is guaranteed to be complete.
 */
public class N222CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
