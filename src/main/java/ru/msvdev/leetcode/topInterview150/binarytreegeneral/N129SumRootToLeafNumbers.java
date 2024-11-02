package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 129. Sum Root to Leaf Numbers
 * <p>
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * <p>
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * <p>
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer
 * will fit in a 32-bit integer.
 * A leaf node is a node with no children.
 * <p>
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * <p>
 * Example 2:
 * Input: root = [4,9,0,5,1]
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [1, 1000].
 * -- 0 <= Node.val <= 9
 * -- The depth of the tree will not exceed 10.
 */
public class N129SumRootToLeafNumbers {

    public int sumNumbers1(TreeNode root) {
        return sumNumbers1(root, 0);
    }

    private int sumNumbers1(TreeNode root, int previousSum) {
        int sum = previousSum + root.val;
        if (root.left == null && root.right == null) return sum;

        sum *= 10;

        return ((root.left != null) ? sumNumbers1(root.left, sum) : 0) +
                ((root.right != null) ? sumNumbers1(root.right, sum) : 0);

    }


    public int sumNumbers2(TreeNode root) {
        return sumNumbers2(root, 0);
    }

    private int sumNumbers2(TreeNode root, int previousSum) {
        if (root == null) return 0;
        int sum = previousSum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        return sumNumbers2(root.left, sum) + sumNumbers2(root.right, sum);

    }
}
