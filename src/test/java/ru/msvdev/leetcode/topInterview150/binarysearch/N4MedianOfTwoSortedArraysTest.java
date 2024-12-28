package ru.msvdev.leetcode.topInterview150.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N4MedianOfTwoSortedArraysTest {

    @ParameterizedTest
    @MethodSource("testData")
    void findMedianSortedArrays1(int[] nums1, int[] nums2, double out) {
        // region Given
        var solution = new N4MedianOfTwoSortedArrays();
        // endregion

        // region When
        var answer = solution.findMedianSortedArrays1(nums1, nums2);
        // endregion

        // region Then
        assertEquals(out, answer, 1e-10);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void findMedianSortedArrays2(int[] nums1, int[] nums2, double out) {
        // region Given
        var solution = new N4MedianOfTwoSortedArrays();
        // endregion

        // region When
        var answer = solution.findMedianSortedArrays2(nums1, nums2);
        // endregion

        // region Then
        assertEquals(out, answer, 1e-10);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3},
                        new int[]{2},
                        2.0
                ),
                Arguments.of(
                        new int[]{1, 2},
                        new int[]{3, 4},
                        2.5
                ),
                Arguments.of(
                        new int[]{10, 12, 14, 18, 28},
                        new int[]{7, 8, 11, 13, 15, 20},
                        13
                ),
                Arguments.of(
                        new int[]{5, 7, 8, 11},
                        new int[]{4, 9, 12, 14},
                        8.5
                )
        );
    }
}