package ru.msvdev.leetcode.topInterview150.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N67AddBinaryTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addBinary1(String a, String b, String out) {
        // region Given
        var solution = new N67AddBinary();
        // endregion

        // region When
        var answer = solution.addBinary1(a, b);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void addBinary2(String a, String b, String out) {
        // region Given
        var solution = new N67AddBinary();
        // endregion

        // region When
        var answer = solution.addBinary2(a, b);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        "11",
                        "1",
                        "100"
                ),
                Arguments.of(
                        "1010",
                        "1011",
                        "10101"
                ),
                Arguments.of(
                        "1111",
                        "1111",
                        "11110"
                )
        );
    }
}