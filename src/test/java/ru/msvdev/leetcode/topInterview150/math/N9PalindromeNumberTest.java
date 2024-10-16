package ru.msvdev.leetcode.topInterview150.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N9PalindromeNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome1(int x, boolean out) {
        // region Given
        var solution = new N9PalindromeNumber();
        // endregion

        // region When
        var answer = solution.isPalindrome1(x);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome2(int x, boolean out) {
        // region Given
        var solution = new N9PalindromeNumber();
        // endregion

        // region When
        var answer = solution.isPalindrome2(x);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome3(int x, boolean out) {
        // region Given
        var solution = new N9PalindromeNumber();
        // endregion

        // region When
        var answer = solution.isPalindrome3(x);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(2_147_483_647, false),
                Arguments.of(2_147_447_412, true)
        );
    }
}