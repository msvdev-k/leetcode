package ru.msvdev.leetcode.topInterview150.binarytreebfs;

import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * <p>
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of
 * the nodes you can see ordered from top to bottom.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * -- The number of nodes in the tree is in the range [0, 100].
 * -- -100 <= Node.val <= 100
 */
public class N199BinaryTreeRightSideView {

    private final List<Integer> rightSideValues = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 1);
        return rightSideValues;
    }

    private void rightSideView(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > rightSideValues.size()) rightSideValues.add(node.val);

        depth++;
        rightSideView(node.right, depth);
        rightSideView(node.left, depth);
    }
}
