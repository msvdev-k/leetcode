package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N219ContainsDuplicateIITest {

    @ParameterizedTest
    @MethodSource("testData")
    void containsNearbyDuplicate(int[] nums, int k, boolean out) {
        // region Given
        var solution = new N219ContainsDuplicateII();
        // endregion

        // region When
        var answer = solution.containsNearbyDuplicate(nums, k);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 3, true),
                Arguments.of(new int[]{1, 0, 1, 1}, 1, true),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3}, 2, false),
                Arguments.of(new int[]{1, 1, 1, 1}, 0, false)
        );
    }
}