package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N242ValidAnagramTest {

    @ParameterizedTest
    @MethodSource("canConstructTestData")
    void isAnagram1(String s, String t, boolean out) {
        // region Given
        N242ValidAnagram solution = new N242ValidAnagram();
        // endregion


        // region When
        boolean anagram = solution.isAnagram1(s, t);
        // endregion


        // region Then
        assertEquals(out, anagram);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("canConstructTestData")
    void isAnagram2(String s, String t, boolean out) {
        // region Given
        N242ValidAnagram solution = new N242ValidAnagram();
        // endregion


        // region When
        boolean anagram = solution.isAnagram2(s, t);
        // endregion


        // region Then
        assertEquals(out, anagram);
        // endregion
    }


    private static Stream<Arguments> canConstructTestData() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }
}