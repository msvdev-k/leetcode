package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N290WordPatternTest {

    @ParameterizedTest
    @MethodSource("wordPatternTestData")
    void wordPattern(String pattern, String s, boolean out) {
        // region Given
        N290WordPattern solution = new N290WordPattern();
        // endregion


        // region When
        boolean canConstruct = solution.wordPattern(pattern, s);
        // endregion


        // region Then
        assertEquals(out, canConstruct);
        // endregion
    }

    private static Stream<Arguments> wordPatternTestData() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("abba", "dog cat cat fish", false),
                Arguments.of("aaaa", "dog cat cat dog", false)
        );
    }
}