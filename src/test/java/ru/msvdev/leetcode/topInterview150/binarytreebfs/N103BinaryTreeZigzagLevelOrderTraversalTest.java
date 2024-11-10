package ru.msvdev.leetcode.topInterview150.binarytreebfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNode;
import ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils;

import java.util.stream.Stream;

class N103BinaryTreeZigzagLevelOrderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void zigzagLevelOrder(Integer[] root, Integer[][] out) {
        // region Given
        var solution = new N103BinaryTreeZigzagLevelOrderTraversal();
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);
        // endregion

        // region When
        var answer = solution.zigzagLevelOrder(rootTreeNode);
        // endregion

        // region Then
        Integer[][] answerArray = answer.stream()
                .map(list -> list.toArray(new Integer[0]))
                .toList()
                .toArray(new Integer[0][]);
        Assertions.assertArrayEquals(out, answerArray);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 9, 20, null, null, 15, 7},
                        new Integer[][]{{3}, {20, 9}, {15, 7}}
                ),
                Arguments.of(
                        new Integer[]{1},
                        new Integer[][]{{1}}
                ),
                Arguments.of(
                        new Integer[0],
                        new Integer[0][]
                )
        );
    }
}