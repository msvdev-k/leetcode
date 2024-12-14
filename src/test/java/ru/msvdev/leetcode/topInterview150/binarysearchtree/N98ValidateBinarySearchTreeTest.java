package ru.msvdev.leetcode.topInterview150.binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils;

import java.util.stream.Stream;

class N98ValidateBinarySearchTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isValidBST(Integer[] root, boolean out) {
        // region Given
        var solution = new N98ValidateBinarySearchTree();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.isValidBST(rootTreeNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{-2147483648},
                        true
                ), Arguments.of(
                        new Integer[]{2, 1, 3},
                        true
                ),
                Arguments.of(
                        new Integer[]{5, 1, 4, null, null, 3, 6},
                        false
                ),
                Arguments.of(
                        new Integer[]{0},
                        true
                ),
                Arguments.of(
                        new Integer[]{1, 1},
                        false
                ),
                Arguments.of(
                        new Integer[]{0, -1},
                        true
                ),
                Arguments.of(
                        new Integer[]{5, 14, null, 1},
                        false
                ),
                Arguments.of(
                        new Integer[]{5, 4, 6, null, null, 3, 7},
                        false
                ),
                Arguments.of(
                        new Integer[]{10, 5, 15, null, null, 6, 20},
                        false
                ),
                Arguments.of(
                        new Integer[]{32, 26, 47, 19, null, null, 56, null, 27},
                        false
                ),
                Arguments.of(
                        new Integer[]{3, null, 30, 10, null, null, 15, null, 45},
                        false
                ),
                Arguments.of(
                        new Integer[]{120, 70, 140, 50, 100, 130, 160, 20, 55, 75, 110, 119, 135, 150, 200},
                        false
                ),
                Arguments.of(
                        new Integer[]{120, 70, 140, 50, 100, 130, 160, 20, 55, 75, 110, 129, 135, 150, 200},
                        true
                )
        );
    }
}