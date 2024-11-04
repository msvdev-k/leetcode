package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N236LowestCommonAncestorOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void lowestCommonAncestor(Integer[] root, int p, int q, int out) {
        // region Given
        var solution = new N236LowestCommonAncestorOfBinaryTree();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        assert rootTreeNode != null;
        TreeNode pNode = (rootTreeNode.val == p) ? rootTreeNode : findNode(rootTreeNode, p);
        TreeNode qNode = (rootTreeNode.val == q) ? rootTreeNode : findNode(rootTreeNode, q);
        // endregion

        // region When
        var answer = solution.lowestCommonAncestor(rootTreeNode, pNode, qNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer.val);
        // endregion
    }

    private TreeNode findNode(TreeNode node, int val) {
        if (node.left != null) {
            if (node.left.val == val) return node.left;
            TreeNode outNode = findNode(node.left, val);
            if (outNode != null) return outNode;
        }
        if (node.right != null) {
            if (node.right.val == val) return node.right;
            return findNode(node.right, val);
        }
        return null;
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
                        2, 8, 3
                ),
                Arguments.of(
                        new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
                        5, 4, 5
                )
        );
    }
}