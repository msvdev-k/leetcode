package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class N117PopulatingNextRightPointersInEachNodeIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void connect1(Integer[] root, Integer[] out) {
        // region Given
        var solution = new N117PopulatingNextRightPointersInEachNodeII();
        Node rootNode = NodeUtils.treeNodeMapToNodeTree(root);
        // endregion

        // region When
        var answer = solution.connect1(rootNode);
        // endregion

        // region Then
        Integer[] mapFromTree = NodeUtils.mapFromTree(answer);
        System.out.println(Arrays.toString(mapFromTree));
        Assertions.assertArrayEquals(out, mapFromTree);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void connect2(Integer[] root, Integer[] out) {
        // region Given
        var solution = new N117PopulatingNextRightPointersInEachNodeII();
        Node rootNode = NodeUtils.treeNodeMapToNodeTree(root);
        // endregion

        // region When
        var answer = solution.connect2(rootNode);
        // endregion

        // region Then
        Integer[] mapFromTree = NodeUtils.mapFromTree(answer);
        System.out.println(Arrays.toString(mapFromTree));
        Assertions.assertArrayEquals(out, mapFromTree);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new Integer[]{1, 2, 3, 4, 5, null, 7},
                        new Integer[]{1, null, 2, 3, null, 4, 5, 7, null}
                ),
                Arguments.of(
                        new Integer[0],
                        new Integer[0]
                ),
                Arguments.of(
                        new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8},
                        new Integer[]{1, null, 2, 3, null, 4, 5, 6, null, 7, 8, null}
                )
        );
    }
}