package ru.msvdev.leetcode.topInterview150.binarytreebfs;

import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
 * level by level).
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
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
 * -- -1000 <= Node.val <= 1000
 */
public class N102BinaryTreeLevelOrderTraversal {

    private final List<List<Integer>> lavalValues = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrder(root, 0);
        return lavalValues;
    }

    private void levelOrder(TreeNode node, int level) {
        if (node == null) return;
        if (level < lavalValues.size()) {
            lavalValues.get(level).add(node.val);
        } else {
            List<Integer> levelList = new ArrayList<>();
            levelList.add(node.val);
            lavalValues.add(levelList);
        }

        level++;
        levelOrder(node.left, level);
        levelOrder(node.right, level);
    }

}
