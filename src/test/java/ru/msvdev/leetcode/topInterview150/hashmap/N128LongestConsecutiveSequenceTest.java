package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N128LongestConsecutiveSequenceTest {

    @ParameterizedTest
    @MethodSource("testData")
    void longestConsecutive(int[] nums, int out) {
        // region Given
        var solution = new N128LongestConsecutiveSequence();
        // endregion

        // region When
        var answer = solution.longestConsecutive(nums);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{100, 4, 200, 1, 3, 2}, 4),
                Arguments.of(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9),
                Arguments.of(new int[]{1, 2, 0, 1}, 3),
                Arguments.of(new int[]{0}, 1),
                Arguments.of(new int[]{0, 0}, 1),
                Arguments.of(new int[0], 0)
        );
    }
}