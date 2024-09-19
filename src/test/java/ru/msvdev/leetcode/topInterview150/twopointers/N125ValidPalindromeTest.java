package ru.msvdev.leetcode.topInterview150.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N125ValidPalindromeTest {

    @ParameterizedTest
    @MethodSource("isPalindromeTestData")
    void isPalindrome(String s, boolean out) {
        // region Given
        N125ValidPalindrome solution = new N125ValidPalindrome();
        // endregion


        // region When
        boolean palindrome = solution.isPalindrome(s);
        // endregion


        // region Then
        assertEquals(out, palindrome);
        // endregion
    }


    private static Stream<Arguments> isPalindromeTestData() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true),
                Arguments.of(" ...,,,   !@#$(*&)  ", true),
                Arguments.of("123321", true),
                Arguments.of("123322", false)
        );
    }
}