package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N226InvertBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void invertTree(Integer[] root, Integer[] out) {
        // region Given
        var solution = new N226InvertBinaryTree();
        var rootTree = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.invertTree(rootTree);
        // endregion

        // region Then
        var answerArray = TreeNodeUtils.mapFromTree(answer);
        Assertions.assertArrayEquals(out, answerArray);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{4, 2, 7, 1, 3, 6, 9},
                        new Integer[]{4, 7, 2, 9, 6, 3, 1}
                ),
                Arguments.of(
                        new Integer[]{2, 1, 3},
                        new Integer[]{2, 3, 1}
                ),
                Arguments.of(
                        new Integer[0],
                        new Integer[0]
                )
        );
    }
}