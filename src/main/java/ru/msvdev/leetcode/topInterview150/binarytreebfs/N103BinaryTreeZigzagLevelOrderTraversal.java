package ru.msvdev.leetcode.topInterview150.binarytreebfs;

import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * <p>
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [0, 2000].
 * -- -100 <= Node.val <= 100
 */
public class N103BinaryTreeZigzagLevelOrderTraversal {

    private final List<List<Integer>> levelValues = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levelOrder(root, 0);

        for (int i = 1; i < levelValues.size(); i++) {
            if (i % 2 == 1) Collections.reverse(levelValues.get(i));
        }

        return levelValues;
    }

    private void levelOrder(TreeNode node, int level) {
        if (node == null) return;

        if (level < levelValues.size()) {
            levelValues.get(level).add(node.val);
        } else {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(node.val);
            levelValues.add(levelList);
        }

        level++;
        levelOrder(node.left, level);
        levelOrder(node.right, level);
    }
}
