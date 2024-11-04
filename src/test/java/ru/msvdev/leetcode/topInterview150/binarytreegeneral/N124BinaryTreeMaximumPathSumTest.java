package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N124BinaryTreeMaximumPathSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void maxPathSum1(Integer[] root, int out) {
        // region Given
        var solution = new N124BinaryTreeMaximumPathSum();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.maxPathSum1(rootTreeNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void maxPathSum2(Integer[] root, int out) {
        // region Given
        var solution = new N124BinaryTreeMaximumPathSum();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.maxPathSum2(rootTreeNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void maxPathSum3(Integer[] root, int out) {
        // region Given
        var solution = new N124BinaryTreeMaximumPathSum();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.maxPathSum3(rootTreeNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 3},
                        6
                ),
                Arguments.of(
                        new Integer[]{-10, 9, 20, null, null, 15, 7},
                        42
                ),
                Arguments.of(
                        new Integer[]{1},
                        1
                ),
                Arguments.of(
                        new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1},
                        48
                ),
                Arguments.of(
                        new Integer[]{9,6,-3,null,null,-6,2,null,null,2,null,-6,-6,-6},
                        16
                ),
                Arguments.of(
                        new Integer[]{-1,8,2,null,-9,0,null,null,null,-3,null,null,-9,null,2},
                        9
                ),
                Arguments.of(
                        new Integer[]{8,9,-6,null,null,5,9},
                        20
                ),
                Arguments.of(
                        new Integer[]{10,-20,-30},
                        10
                )
        );
    }
}