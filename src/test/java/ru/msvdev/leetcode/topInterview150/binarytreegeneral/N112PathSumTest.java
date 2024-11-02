package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N112PathSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasPathSum1(Integer[] root, int target, boolean out) {
        // region Given
        var solution = new N112PathSum();
        TreeNode rootNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.hasPathSum1(rootNode, target);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void hasPathSum2(Integer[] root, int target, boolean out) {
        // region Given
        var solution = new N112PathSum();
        TreeNode rootNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.hasPathSum2(rootNode, target);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1},
                        22, true
                ),
                Arguments.of(
                        new Integer[]{1, 2, 3},
                        5, false
                ),
                Arguments.of(
                        new Integer[0],
                        0, false
                ),
                Arguments.of(
                        new Integer[]{10},
                        10, true
                ),
                Arguments.of(
                        new Integer[]{10},
                        11, false
                ),
                Arguments.of(
                        new Integer[]{1, 2},
                        1, false
                ),
                Arguments.of(
                        new Integer[]{1, 2},
                        2, false
                ),
                Arguments.of(
                        new Integer[]{-2, null, -3},
                        -5, true
                ),
                Arguments.of(
                        new Integer[]{-2, null, -3},
                        0, false
                ),
                Arguments.of(
                        new Integer[]{8, 9, -6, null, null, 5, 9},
                        7, true
                )
        );
    }
}