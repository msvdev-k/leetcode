package ru.msvdev.leetcode.topInterview150.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N136SingleNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void singleNumber1(int[] nums, int out) {
        // region Given
        var solution = new N136SingleNumber();
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
        var solution = new N136SingleNumber();
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
                        new int[]{2, 2, 1},
                        1
                ),
                Arguments.of(
                        new int[]{4, 1, 2, 1, 2},
                        4
                ),
                Arguments.of(
                        new int[]{1},
                        1
                )
        );
    }
}