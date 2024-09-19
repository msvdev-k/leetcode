package ru.msvdev.leetcode.topInterview150.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N135CandyTest {

    @ParameterizedTest
    @MethodSource("candyTestData")
    void candy(int[] ratings, int out) {
        // region Given
        N135Candy solution = new N135Candy();
        // endregion


        // region When
        int candy = solution.candy(ratings);
        // endregion


        // region Then
        assertEquals(out, candy);
        // endregion
    }


    private static Stream<Arguments> candyTestData() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 2}, 5),
                Arguments.of(new int[]{1, 2, 2}, 4),
                Arguments.of(new int[]{0, 1, 2, 2, 2, 2, 1, 0}, 14),
                Arguments.of(new int[]{1, 3, 2, 2, 1}, 7),
                Arguments.of(new int[]{1, 5, 4, 3, 2, 2, 1}, 14),
                Arguments.of(new int[]{1, 2, 3, 1, 0}, 9),
                Arguments.of(new int[]{1, 2, 6, 5, 4, 3, 2, 1, 0}, 31)
        );
    }
}