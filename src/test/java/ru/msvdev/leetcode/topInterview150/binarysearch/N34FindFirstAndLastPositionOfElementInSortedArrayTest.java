package ru.msvdev.leetcode.topInterview150.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class N34FindFirstAndLastPositionOfElementInSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void searchRange(int[] nums, int target, int[] out) {
        // region Given
        var solution = new N34FindFirstAndLastPositionOfElementInSortedArray();
        // endregion

        // region When
        var answer = solution.searchRange(nums, target);
        // endregion

        // region Then
        assertArrayEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{5, 7, 7, 8, 8, 10},
                        8, new int[]{3, 4}
                ),
                Arguments.of(
                        new int[]{5, 7, 7, 8, 8, 10},
                        6, new int[]{-1, -1}
                ),
                Arguments.of(
                        new int[]{},
                        0, new int[]{-1, -1}
                ),
                Arguments.of(
                        new int[]{7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9},
                        7, new int[]{0, 0}
                ),
                Arguments.of(
                        new int[]{7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9},
                        8, new int[]{1, 10}
                ),
                Arguments.of(
                        new int[]{7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9},
                        10, new int[]{-1, -1}
                ),
                Arguments.of(
                        new int[]{1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 9, 10, 11, 12, 12, 12, 12, 12, 13},
                        2, new int[]{1, 4}
                ),
                Arguments.of(
                        new int[]{1},
                        1, new int[]{0, 0}
                )
        );
    }
}