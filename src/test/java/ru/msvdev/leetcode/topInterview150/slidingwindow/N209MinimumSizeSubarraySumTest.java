package ru.msvdev.leetcode.topInterview150.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N209MinimumSizeSubarraySumTest {

    @ParameterizedTest
    @MethodSource("minSubArrayLenTestData")
    void minSubArrayLen1(int target, int[] nums, int out) {
        // region Given
        N209MinimumSizeSubarraySum solution = new N209MinimumSizeSubarraySum();
        // endregion


        // region When
        int minSubArrayLen = solution.minSubArrayLen1(target, nums);
        // endregion


        // region Then
        assertEquals(out, minSubArrayLen);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("minSubArrayLenTestData")
    void minSubArrayLen2(int target, int[] nums, int out) {
        // region Given
        N209MinimumSizeSubarraySum solution = new N209MinimumSizeSubarraySum();
        // endregion


        // region When
        int minSubArrayLen = solution.minSubArrayLen2(target, nums);
        // endregion


        // region Then
        assertEquals(out, minSubArrayLen);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("minSubArrayLenTestData")
    void minSubArrayLen3(int target, int[] nums, int out) {
        // region Given
        N209MinimumSizeSubarraySum solution = new N209MinimumSizeSubarraySum();
        // endregion


        // region When
        int minSubArrayLen = solution.minSubArrayLen3(target, nums);
        // endregion


        // region Then
        assertEquals(out, minSubArrayLen);
        // endregion
    }


    private static Stream<Arguments> minSubArrayLenTestData() {
        return Stream.of(
                Arguments.of(7, new int[]{2, 3, 1, 2, 4, 3}, 2),
                Arguments.of(4, new int[]{1, 4, 4}, 1),
                Arguments.of(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 0),
                Arguments.of(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 11),
                Arguments.of(11, new int[]{1,2,3,4,5}, 3),
                Arguments.of(6, new int[]{10,2,3}, 1)
        );
    }
}