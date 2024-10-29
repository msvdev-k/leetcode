package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N104MaximumDepthOfBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxDepth(Integer[] root, int out) {
        // region Given
        var solution = new N104MaximumDepthOfBinaryTree();
        TreeNode treeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.maxDepth(treeNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 9, 20, null, null, 15, 7},
                        3
                ),
                Arguments.of(
                        new Integer[]{1, null, 2},
                        2
                ),
                Arguments.of(
                        new Integer[]{0, 0, 0, 0, null, null, 0, null, null, null, 0},
                        4
                ),
                Arguments.of(
                        new Integer[]{1, 2, 3, 4, 5, null, null},
                        3
                )
        );
    }
}