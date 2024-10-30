package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N100SameTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSameTree(Integer[] p, Integer[] q, boolean out) {
        // region Given
        var solution = new N100SameTree();
        var pTree = TreeNodeUtils.mapToTree(p);
        var qTree = TreeNodeUtils.mapToTree(q);
        // endregion

        // region When
        var answer = solution.isSameTree(pTree, qTree);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 3},
                        new Integer[]{1, 2, 3},
                        true
                ),
                Arguments.of(
                        new Integer[]{1, 2},
                        new Integer[]{1, null, 2},
                        false
                ),
                Arguments.of(
                        new Integer[]{1, 2, 1},
                        new Integer[]{1, 1, 2},
                        false
                )
        );
    }
}