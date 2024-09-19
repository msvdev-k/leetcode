package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N42TrappingRainWaterTest {

    @ParameterizedTest
    @MethodSource("canCompleteCircuitTestData")
    void trap(int[] height, int out) {
        // region Given
        N42TrappingRainWater solution = new N42TrappingRainWater();
        // endregion


        // region When
        int water = solution.trap(height);
        // endregion


        // region Then
        assertEquals(out, water);
        // endregion
    }


    private static Stream<Arguments> canCompleteCircuitTestData() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                Arguments.of(new int[]{4, 2, 0, 3, 2, 5}, 9),
                Arguments.of(new int[]{0, 1, 1, 1, 1, 0}, 0),
                Arguments.of(new int[]{0, 1, 0, 0, 9, 0}, 2)
        );
    }
}