package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class NodeUtilsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void mapTest(Integer[] nodes, Integer[] out) {
        // region Given
        Node tree = NodeUtils.treeNodeMapToNodeTree(nodes);
        // endregion

        // region When
        var answer = NodeUtils.mapFromTree(tree);
        // endregion

        // region Then
        System.out.println(Arrays.toString(answer));
        Assertions.assertArrayEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{3, 9, 20, null, null, 15, 7},
                        new Integer[]{3, null, 9, 20, null, 15, 7, null}
                ),
                Arguments.of(
                        new Integer[]{1, null, 2},
                        new Integer[]{1, null, 2, null}
                ),
                Arguments.of(
                        new Integer[]{1, 2, 3, 4, null, null, 5, null, null, null, 6, null, null},
                        new Integer[]{1, null, 2, 3, null, 4, 5, null, 6, null}
                ),
                Arguments.of(
                        new Integer[]{1, 2, 3, 4, 5, null, null},
                        new Integer[]{1, null, 2, 3, null, 4, 5, null}
                )
        );
    }
}
