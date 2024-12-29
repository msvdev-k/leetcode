package ru.msvdev.leetcode.topInterview150.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N190ReverseBitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void reverseBits1(int n, int out) {
        // region Given
        var solution = new N190ReverseBits();
        // endregion

        // region When
        var answer = solution.reverseBits1(n);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void reverseBits2(int n, int out) {
        // region Given
        var solution = new N190ReverseBits();
        // endregion

        // region When
        var answer = solution.reverseBits2(n);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(0x02941E9C, 0x39782940),
                Arguments.of(0xFFFFFFFD, 0xBFFFFFFF)
        );
    }
}