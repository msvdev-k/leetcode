package ru.msvdev.leetcode.topInterview150.bitmanipulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N191NumberOf1BitsTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hammingWeight(int n, int out) {
        // region Given
        var solution = new N191NumberOf1Bits();
        // endregion

        // region When
        var answer = solution.hammingWeight(n);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(11, 3),
                Arguments.of(128, 1),
                Arguments.of(2147483645, 30)
        );
    }
}