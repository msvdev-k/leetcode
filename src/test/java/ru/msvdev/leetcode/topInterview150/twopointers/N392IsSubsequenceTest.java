package ru.msvdev.leetcode.topInterview150.twopointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N392IsSubsequenceTest {

    @ParameterizedTest
    @MethodSource("isSubsequenceTestData")
    void isSubsequence1(String s, String t, boolean out) {
        // region Given
        N392IsSubsequence solution = new N392IsSubsequence();
        // endregion


        // region When
        boolean subsequence = solution.isSubsequence1(s, t);
        // endregion


        // region Then
        Assertions.assertEquals(out, subsequence);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("isSubsequenceTestData")
    void isSubsequence2(String s, String t, boolean out) {
        // region Given
        N392IsSubsequence solution = new N392IsSubsequence();
        // endregion


        // region When
        boolean subsequence = solution.isSubsequence2(s, t);
        // endregion


        // region Then
        Assertions.assertEquals(out, subsequence);
        // endregion
    }


    private static Stream<Arguments> isSubsequenceTestData() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("", "ahbgdc", true),
                Arguments.of("ahbgdce", "ahbgdc", false)
        );
    }
}