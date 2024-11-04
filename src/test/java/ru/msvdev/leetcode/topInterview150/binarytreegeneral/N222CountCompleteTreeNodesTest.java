package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N222CountCompleteTreeNodesTest {

    @ParameterizedTest
    @MethodSource("testData")
    void countNodes(Integer[] root, int out) {
        // region Given
        var solution = new N222CountCompleteTreeNodes();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.countNodes(rootTreeNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 3, 4, 5, 6},
                        6
                ),
                Arguments.of(
                        new Integer[0],
                        0
                ),
                Arguments.of(
                        new Integer[]{1},
                        1
                )
        );
    }
}