package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N383RansomNoteTest {

    @ParameterizedTest
    @MethodSource("canConstructTestData")
    void canConstruct(String ransomNote, String magazine, boolean out) {
        // region Given
        N383RansomNote solution = new N383RansomNote();
        // endregion


        // region When
        boolean canConstruct = solution.canConstruct(ransomNote, magazine);
        // endregion


        // region Then
        assertEquals(out, canConstruct);
        // endregion
    }

    private static Stream<Arguments> canConstructTestData() {
        return Stream.of(
                Arguments.of("a", "b", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aab", true)
        );
    }
}