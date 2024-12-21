package ru.msvdev.leetcode.topInterview150.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N162FindPeakElementTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findPeakElement1(int[] nums, int[] out) {
        // region Given
        var solution = new N162FindPeakElement();
        // endregion

        // region When
        var answer = solution.findPeakElement1(nums);
        // endregion

        // region Then
        assertEquals(1L, Arrays.stream(out).filter(it -> it == answer).count());
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findPeakElement2(int[] nums, int[] out) {
        // region Given
        var solution = new N162FindPeakElement();
        // endregion

        // region When
        var answer = solution.findPeakElement2(nums);
        // endregion

        // region Then
        assertEquals(1L, Arrays.stream(out).filter(it -> it == answer).count());
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3, 1},
                        new int[]{2}
                ),
                Arguments.of(
                        new int[]{1, 2, 1, 3, 5, 6, 4},
                        new int[]{1, 5}
                ),
                Arguments.of(
                        new int[]{4, 6, 5, 3, 1, 2, 1},
                        new int[]{1, 5}
                ),
                Arguments.of(
                        new int[]{1},
                        new int[]{0}
                ),
                Arguments.of(
                        new int[]{1, 2},
                        new int[]{1}
                ),
                Arguments.of(
                        new int[]{2, 1},
                        new int[]{0}
                ),
                Arguments.of(
                        new int[]{6, 5, 4, 3, 2, 3, 2},
                        new int[]{0, 5}
                ),
                Arguments.of(
                        new int[]{5, 4, 3, 4, 5},
                        new int[]{0, 4}
                ),
                Arguments.of(
                        new int[]{3, 4, 3, 2, 1},
                        new int[]{1}
                )
        );
    }
}