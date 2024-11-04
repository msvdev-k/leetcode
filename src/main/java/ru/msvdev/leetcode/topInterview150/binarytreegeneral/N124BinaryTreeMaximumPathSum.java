package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

/**
 * 124. Binary Tree Maximum Path Sum
 * <p>
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has
 * an edge connecting them. A node can only appear in the sequence at most once. Note that the path does
 * not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * Example 1:
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * <p>
 * Example 2:
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [1, 3e4].
 * -- -1000 <= Node.val <= 1000
 */
public class N124BinaryTreeMaximumPathSum {

    public int maxPathSum1(TreeNode root) {
        return maxPathSum1(root, Integer.MIN_VALUE).maxSum;
    }

    private SolutionState maxPathSum1(TreeNode node, int maxSum) {
        if (node == null) return new SolutionState(0, maxSum);

        SolutionState leftState = maxPathSum1(node.left, maxSum);
        SolutionState rightState = maxPathSum1(node.right, maxSum);

        int sum = node.val + Math.max(leftState.sum, rightState.sum);
        maxSum = Math.max(maxSum, leftState.maxSum);
        maxSum = Math.max(maxSum, rightState.maxSum);
        maxSum = Math.max(maxSum, node.val + leftState.sum + rightState.sum);

        sum = Math.max(sum, node.val);

        return new SolutionState(sum, Math.max(sum, maxSum));
    }

    private record SolutionState(int sum, int maxSum) {
    }


    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum2(TreeNode root) {
        maxPathSumRecursive2(root);
        return maxSum;
    }

    private int maxPathSumRecursive2(TreeNode node) {
        if (node == null) return 0;

        int leftState = maxPathSumRecursive2(node.left);
        int rightState = maxPathSumRecursive2(node.right);

        int sum = node.val + Math.max(leftState, rightState);
        maxSum = Math.max(maxSum, node.val + leftState + rightState);

        sum = Math.max(sum, node.val);
        maxSum = Math.max(sum, maxSum);

        return sum;
    }


    public int maxPathSum3(TreeNode root) {
        maxPathSumRecursive3(root);
        return maxSum;
    }

    private int maxPathSumRecursive3(TreeNode node) {
        if (node == null) return 0;

        int sum1 = maxPathSumRecursive3(node.left);
        int sum2 = maxPathSumRecursive3(node.right);

        if (sum2 < sum1) {
            int tmp = sum1;
            sum1 = sum2;
            sum2 = tmp;
        }

        if (sum2 > 0) {
            int sum = node.val + sum2;
            if (sum1 > 0) {
                maxSum = Math.max(maxSum, sum + sum1);
            } else if (maxSum < sum) {
                maxSum = sum;
            }
            return sum;
        }

        if (maxSum < node.val) maxSum = node.val;
        return node.val;
    }

}
