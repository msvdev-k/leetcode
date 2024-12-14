package ru.msvdev.leetcode.topInterview150.binarysearchtree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils;

import java.util.stream.Stream;

class N530MinimumAbsoluteDifferenceInBSTTest {

    @ParameterizedTest
    @MethodSource("testData")
    void getMinimumDifference(Integer[] root, int out) {
        // region Given
        var solution = new N530MinimumAbsoluteDifferenceInBST();
        TreeNode treeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.getMinimumDifference(treeNode);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{4, 2, 6, 1, 3},
                        1
                ),
                Arguments.of(
                        new Integer[]{1, 0, 48, null, null, 12, 49},
                        1
                )
        );
    }
}