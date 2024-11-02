package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N129SumRootToLeafNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void sumNumbers1(Integer[] root, int out) {
        // region Given
        var solution = new N129SumRootToLeafNumbers();
        TreeNode rootNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.sumNumbers1(rootNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void sumNumbers2(Integer[] root, int out) {
        // region Given
        var solution = new N129SumRootToLeafNumbers();
        TreeNode rootNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.sumNumbers2(rootNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }



    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 3},
                        25
                ),
                Arguments.of(
                        new Integer[]{4, 9, 0, 5, 1},
                        1026
                ),
                Arguments.of(
                        new Integer[]{2, 1, null, 4, null, 7, null, 4, null, 8, null, 3, null, 6, null, 4, null, 7},
                        2147483647
                )
        );
    }
}