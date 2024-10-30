package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N101SymmetricTreeTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isSymmetric(Integer[] root, boolean out) {
        // region Given
        var solution = new N101SymmetricTree();
        var rootTree = TreeNodeUtils.mapToTree(root);
        assert rootTree != null;
        // endregion

        // region When
        var answer = solution.isSymmetric(rootTree);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 2, 3, 4, 4, 3},
                        true
                ),
                Arguments.of(
                        new Integer[]{1, 2, 2, null, 3, null, 3},
                        false
                ),
                Arguments.of(
                        new Integer[]{1, 2, 2, 5, null, null, 5, 6, null, null, 6},
                        true
                ),
                Arguments.of(
                        new Integer[]{1, 2, 2, 2, null, 2, null},
                        false
                )
        );
    }
}