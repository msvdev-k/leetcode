package ru.msvdev.leetcode.topInterview150.binarytreebfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils;

import java.util.stream.Stream;

class N637AverageOfLevelsInBinaryTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void averageOfLevels(Integer[] root, double[] out) {
        // region Given
        var solution = new N637AverageOfLevelsInBinaryTree();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.averageOfLevels(rootTreeNode);
        // endregion

        // region Then
        double[] answerArray = answer.stream().mapToDouble(Double::doubleValue).toArray();
        Assertions.assertArrayEquals(out, answerArray, 1e-12);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 9, 20, null, null, 15, 7},
                        new double[]{3.00000, 14.50000, 11.00000}
                ),
                Arguments.of(
                        new Integer[]{3, 9, 20, 15, 7},
                        new double[]{3.00000, 14.50000, 11.00000}
                )
        );
    }
}