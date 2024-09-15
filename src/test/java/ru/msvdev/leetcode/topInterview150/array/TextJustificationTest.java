package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;


class TextJustificationTest {

    @ParameterizedTest
    @MethodSource("fullJustifyTestData")
    void fullJustify(String[] words, int maxWidth, List<String> out) {
        // region Given
        TextJustification solution = new TextJustification();
        // endregion


        // region When
        List<String> fullJustify = solution.fullJustify(words, maxWidth);
        // endregion


        // region Then
        assertIterableEquals(out, fullJustify);
        // endregion
    }


    private static Stream<Arguments> fullJustifyTestData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"This", "is", "an", "example", "of", "text", "justification."},
                        16,
                        List.of("This    is    an",
                                "example  of text",
                                "justification.  ")
                ),
                Arguments.of(
                        new String[]{"What", "must", "be", "acknowledgment", "shall", "be"},
                        16,
                        List.of("What   must   be",
                                "acknowledgment  ",
                                "shall be        ")
                ),
                Arguments.of(
                        new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to",
                                "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
                        20,
                        List.of("Science  is  what we",
                                "understand      well",
                                "enough to explain to",
                                "a  computer.  Art is",
                                "everything  else  we",
                                "do                  ")
                ),
                Arguments.of(
                        new String[]{"acknowledgment"},
                        14,
                        List.of("acknowledgment")
                ),
                Arguments.of(
                        new String[]{"acknowledgment"},
                        20,
                        List.of("acknowledgment      ")
                )
        );
    }
}