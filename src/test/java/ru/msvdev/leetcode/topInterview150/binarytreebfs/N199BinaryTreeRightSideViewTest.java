package ru.msvdev.leetcode.topInterview150.binarytreebfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils;

import java.util.Arrays;
import java.util.stream.Stream;

class N199BinaryTreeRightSideViewTest {

    @ParameterizedTest
    @MethodSource("testData")
    void rightSideView(Integer[] root, Integer[] out) {
        // region Given
        var solution = new N199BinaryTreeRightSideView();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.rightSideView(rootTreeNode);
        // endregion

        // region Then
        Assertions.assertEquals(Arrays.stream(out).toList(), answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 3, null, 5, null, 4},
                        new Integer[]{1, 3, 4}
                ),
                Arguments.of(
                        new Integer[]{1, null, 3},
                        new Integer[]{1, 3}
                ),
                Arguments.of(
                        new Integer[0],
                        new Integer[0]
                ),
                Arguments.of(
                        new Integer[]{1, 2, 3, null, 5, 6, null, 4},
                        new Integer[]{1, 3, 6, 4}
                )
        );
    }
}