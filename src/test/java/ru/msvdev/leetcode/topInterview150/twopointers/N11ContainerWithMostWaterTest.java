package ru.msvdev.leetcode.topInterview150.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N11ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource("maxAreaTestData")
    void maxArea1(int[] height, int out) {
        // region Given
        N11ContainerWithMostWater solution = new N11ContainerWithMostWater();
        // endregion


        // region When
        int volume = solution.maxArea1(height);
        // endregion


        // region Then
        assertEquals(out, volume);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("maxAreaTestData")
    void maxArea2(int[] height, int out) {
        // region Given
        N11ContainerWithMostWater solution = new N11ContainerWithMostWater();
        // endregion


        // region When
        int volume = solution.maxArea2(height);
        // endregion


        // region Then
        assertEquals(out, volume);
        // endregion
    }

    private static Stream<Arguments> maxAreaTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                Arguments.of(new int[]{1, 1}, 1)
        );
    }
}