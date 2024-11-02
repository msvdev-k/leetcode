package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N114FlattenBinaryTreeToLinkedListTest {

    @ParameterizedTest
    @MethodSource("testData")
    void flatten(Integer[] root, Integer[] out) {
        // region Given
        var solution = new N114FlattenBinaryTreeToLinkedList();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        solution.flatten(rootTreeNode);
        // endregion

        // region Then
        Integer[] mapFromTree = TreeNodeUtils.mapFromTree(rootTreeNode);
        Assertions.assertArrayEquals(out, mapFromTree);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 5, 3, 4, null, 6},
                        new Integer[]{1, null, 2, null, 3, null, 4, null, 5, null, 6}
                ),
                Arguments.of(
                        new Integer[]{},
                        new Integer[]{}
                ),
                Arguments.of(
                        new Integer[]{0},
                        new Integer[]{0}
                )
        );
    }
}