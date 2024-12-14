package ru.msvdev.leetcode.topInterview150.binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils;

import java.util.stream.Stream;

class N230KthSmallestElementInBSTTest {

    @ParameterizedTest
    @MethodSource("testData")
    void kthSmallest1(Integer[] root, int k, int out) {
        // region Given
        var solution = new N230KthSmallestElementInBST();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.kthSmallest1(rootTreeNode, k);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void kthSmallest2(Integer[] root, int k, int out) {
        // region Given
        var solution = new N230KthSmallestElementInBST();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.kthSmallest2(rootTreeNode, k);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 1, 4, null, 2},
                        1, 1
                ),
                Arguments.of(
                        new Integer[]{3, 1, 4, null, 2},
                        4, 4
                ),
                Arguments.of(
                        new Integer[]{5, 3, 6, 2, 4, null, null, 1},
                        3, 3
                ),
                Arguments.of(
                        new Integer[]{5, 3, 6, 2, 4, null, null, 1},
                        5, 5
                )
        );
    }
}