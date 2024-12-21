package ru.msvdev.leetcode.topInterview150.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N33SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void search(int[] nums, int target, int out) {
        // region Given
        var solution = new N33SearchInRotatedSortedArray();
        // endregion

        // region When
        var answer = solution.search(nums, target);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{4, 5, 6, 7, 0, 1, 2},
                        0, 4
                ),
                Arguments.of(
                        new int[]{4, 5, 6, 7, 0, 1, 2},
                        3, -1
                ),
                Arguments.of(
                        new int[]{1},
                        0, -1
                ),
                Arguments.of(
                        new int[]{1, 3},
                        3, 1
                ),
                Arguments.of(
                        new int[]{5,1,3},
                        5, 0
                ),
                Arguments.of(
                        new int[]{4,5,1,2,3},
                        5, 1
                ),
                Arguments.of(
                        new int[]{1,3,5},
                        5, 2
                )
        );
    }
}