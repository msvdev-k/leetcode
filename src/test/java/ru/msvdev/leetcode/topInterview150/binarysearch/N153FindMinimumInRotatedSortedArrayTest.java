package ru.msvdev.leetcode.topInterview150.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N153FindMinimumInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMin(int[] nums, int out) {
        // region Given
        var solution = new N153FindMinimumInRotatedSortedArray();
        // endregion

        // region When
        var answer = solution.findMin(nums);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 4, 5, 1, 2},
                        1
                ),
                Arguments.of(
                        new int[]{4, 5, 6, 7, 0, 1, 2},
                        0
                ),
                Arguments.of(
                        new int[]{11, 13, 15, 17},
                        11
                ),
                Arguments.of(
                        new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3},
                        0
                ),
                Arguments.of(
                        new int[]{5, 1, 2, 3, 4},
                        1
                ),
                Arguments.of(
                        new int[]{4, 5, 6, 1, 2, 3},
                        1
                ),
                Arguments.of(
                        new int[]{4, 5, 1, 2, 3},
                        1
                )
        );
    }
}