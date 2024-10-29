package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils.mapFromTree;
import static ru.msvdev.leetcode.topInterview150.binarytreegeneral.TreeNodeUtils.mapToTree;

public class TreeNodeUtilsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mapTest(Integer[] nodes) {
        // region Given
        TreeNode tree = mapToTree(nodes);
        // endregion

        // region When
        var answer = mapFromTree(tree);
        // endregion

        // region Then
        Assertions.assertArrayEquals(nodes, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        (Object) new Integer[]{3, 9, 20, null, null, 15, 7}
                ),
                Arguments.of(
                        (Object) new Integer[]{1, null, 2}
                ),
                Arguments.of(
                        (Object) new Integer[]{0, 0, 0, 0, null, null, 0, null, null, null, 0}
                ),
                Arguments.of(
                        (Object) new Integer[]{1, 2, 3, 4, 5, null, null}
                )
        );
    }
}
