package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class N1TwoSumTest {

    @ParameterizedTest
    @MethodSource("testData")
    void twoSum(int[] nums, int target, int[] out) {
        // region Given
        var solution = new N1TwoSum();
        // endregion


        // region When
        var answer = solution.twoSum(nums, target);
        // endregion


        // region Then
        assertArrayEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }
}