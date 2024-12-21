package ru.msvdev.leetcode.topInterview150.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N35SearchInsertPositionTest {

    @ParameterizedTest
    @MethodSource("testData")
    void searchInsert1(int[] nums, int target, int out) {
        // region Given
        var solution = new N35SearchInsertPosition();
        // endregion

        // region When
        var answer = solution.searchInsert1(nums, target);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void searchInsert2(int[] nums, int target, int out) {
        // region Given
        var solution = new N35SearchInsertPosition();
        // endregion

        // region When
        var answer = solution.searchInsert2(nums, target);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 5, 6},
                        5, 2
                ),
                Arguments.of(
                        new int[]{1, 3, 5, 6},
                        2, 1
                ),
                Arguments.of(
                        new int[]{1, 3, 5, 6},
                        7, 4
                ),
                Arguments.of(
                        new int[]{1, 3, 5, 7},
                        4, 2
                ),
                Arguments.of(
                        new int[]{1, 3, 5, 7},
                        6, 3
                )
                ,
                Arguments.of(
                        new int[]{1, 3, 5, 7},
                        -1, 0
                )
        );
    }
}