package ru.msvdev.leetcode.topInterview150.binarytreebfs;

import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. Average of Levels in Binary Tree
 * <p>
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 1e-5 of the actual answer will be accepted.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * <p>
 * Example 2:
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [1, 1e4].
 * -- -2^31 <= Node.val <= 2^31 - 1
 */
public class N637AverageOfLevelsInBinaryTree {

    private final List<Double> averageOfLevels = new ArrayList<>();
    private final List<Integer> countsOfLevels = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        averageOfLevels(root, 0);
        for (int i = 0; i < averageOfLevels.size(); i++) {
            averageOfLevels.set(i, averageOfLevels.get(i) / countsOfLevels.get(i));
        }
        return averageOfLevels;
    }

    private void averageOfLevels(TreeNode node, int level) {
        if (node == null) return;
        if (level < averageOfLevels.size()) {
            averageOfLevels.set(level, averageOfLevels.get(level) + node.val);
            countsOfLevels.set(level, countsOfLevels.get(level) + 1);
        } else {
            averageOfLevels.add((double) node.val);
            countsOfLevels.add(1);
        }

        level++;
        averageOfLevels(node.left, level);
        averageOfLevels(node.right, level);
    }
}
