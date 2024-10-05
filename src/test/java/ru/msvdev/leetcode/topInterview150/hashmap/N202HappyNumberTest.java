package ru.msvdev.leetcode.topInterview150.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class N202HappyNumberTest {

    @ParameterizedTest
    @MethodSource("testData")
    void isHappy(int n, boolean out) {
        // region Given
        var solution = new N202HappyNumber();
        // endregion

        // region When
        var answer = solution.isHappy(n);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false),
                Arguments.of(1_352_596_845, false),
                Arguments.of(1_999_999_999, false),
                Arguments.of(7, true)
        );
    }
}