package ru.msvdev.leetcode.topInterview150.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class N167TwoSumII_InputArrayIsSortedTest {

    @ParameterizedTest
    @MethodSource("twoSumTestData")
    void twoSum1(int[] numbers, int target, int[] out) {
        // region Given
        N167TwoSumII_InputArrayIsSorted solution = new N167TwoSumII_InputArrayIsSorted();
        // endregion


        // region When
        int[] indexes = solution.twoSum1(numbers, target);
        // endregion


        // region Then
        assertArrayEquals(out, indexes);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("twoSumTestData")
    void twoSum2(int[] numbers, int target, int[] out) {
        // region Given
        N167TwoSumII_InputArrayIsSorted solution = new N167TwoSumII_InputArrayIsSorted();
        // endregion


        // region When
        int[] indexes = solution.twoSum2(numbers, target);
        // endregion


        // region Then
        assertArrayEquals(out, indexes);
        // endregion
    }


    private static Stream<Arguments> twoSumTestData() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }
}