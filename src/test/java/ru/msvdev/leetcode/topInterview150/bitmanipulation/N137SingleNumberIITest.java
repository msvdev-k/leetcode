package ru.msvdev.leetcode.topInterview150.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N137SingleNumberIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void singleNumber1(int[] nums, int out) {
        // region Given
        var solution = new N137SingleNumberII();
        // endregion

        // region When
        var answer = solution.singleNumber1(nums);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void singleNumber2(int[] nums, int out) {
        // region Given
        var solution = new N137SingleNumberII();
        // endregion

        // region When
        var answer = solution.singleNumber2(nums);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 2, 3, 2},
                        3
                ),
                Arguments.of(
                        new int[]{0, 1, 0, 1, 0, 1, 99},
                        99
                )
        );
    }
}