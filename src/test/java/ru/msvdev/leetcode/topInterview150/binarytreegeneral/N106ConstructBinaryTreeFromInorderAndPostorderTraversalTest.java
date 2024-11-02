package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class N106ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    @ParameterizedTest
    @MethodSource("testData")
    void buildTree(int[] inorder, int[] postorder, Integer[] out) {
        // region Given
        var solution = new N106ConstructBinaryTreeFromInorderAndPostorderTraversal();
        // endregion

        // region When
        var answer = solution.buildTree(inorder, postorder);
        // endregion

        // region Then
        Integer[] mapFromTree = TreeNodeUtils.mapFromTree(answer);
        System.out.println(Arrays.toString(mapFromTree));
        Assertions.assertArrayEquals(out, mapFromTree);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{9, 3, 15, 20, 7},
                        new int[]{9, 15, 7, 20, 3},
                        new Integer[]{3, 9, 20, null, null, 15, 7}
                ),
                Arguments.of(
                        new int[]{-1},
                        new int[]{-1},
                        new Integer[]{-1}
                ),
                Arguments.of(
                        new int[]{10, 9, 3, 11, 15, 20, 7},
                        new int[]{10, 9, 11, 15, 7, 20, 3},
                        new Integer[]{3, 9, 20, 10, null, 15, 7, null, null, 11, null, null, null}
                ),
                Arguments.of(
                        new int[]{4, 2, 5, 6, 1, 3, 8, 9, 7, 10},
                        new int[]{4, 5, 6, 2, 9, 8, 10, 7, 3, 1},
                        new Integer[]{1, 2, 3, 4, 6, null, 7, null, null, 5, null, 8, 10, null, null, null, 9, null, null}
                ),
                Arguments.of(
                        new int[]{3, 2, 6, 17, 1, 7, 5, 9, 8, 4, 10, 14, 13, 11, 20, 15, 19},
                        new int[]{6, 2, 1, 7, 17, 3, 8, 9, 5, 14, 13, 20, 19, 15, 11, 10, 4},
                        new Integer[]{4, 5, 10, 3, 9, null, 11, null, 17, null, 8, 13, 15, 2, 7, null, null, 14, null, 20, 19, null, 6, 1, null, null, null, null, null, null, null}
                )
        );
    }
}