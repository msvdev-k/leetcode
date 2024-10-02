package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N205IsomorphicStringsTest {

    @ParameterizedTest
    @MethodSource("isIsomorphicTestData")
    void isIsomorphic(String s, String t, boolean out) {
        // region Given
        N205IsomorphicStrings solution = new N205IsomorphicStrings();
        // endregion


        // region When
        boolean isomorphic = solution.isIsomorphic(s, t);
        // endregion


        // region Then
        assertEquals(out, isomorphic);
        // endregion
    }


    private static Stream<Arguments> isIsomorphicTestData() {
        return Stream.of(
                Arguments.of("egg", "add", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("paper", "title", true),
                Arguments.of("badc", "baba", false)
        );
    }
}