package ru.msvdev.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class TestUtilsTest {

    @ParameterizedTest
    @MethodSource("equalsListListTestData")
    void equalsListList(List<List<Integer>> first, List<List<Integer>> second, boolean out) {
        // region Given
        // endregion

        // region When
        var answer = TestUtils.equalsListList(first, second);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }

    @ParameterizedTest
    @MethodSource("equalsListTestData")
    void equalsList(List<Integer> first, List<Integer> second, boolean out) {
        // region Given
        // endregion

        // region When
        var answer = TestUtils.equalsList(first, second);
        // endregion

        // region Then
        Assertions.assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> equalsListListTestData() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of(12, 34, 3, 2, 3, 4, 12, 3), List.of(34, 3, 3)
                        ),
                        List.of(
                                List.of(3, 34, 3), List.of(34, 3, 3, 12, 2, 4, 12, 3)
                        ),
                        true
                ),
                Arguments.of(
                        List.of(
                                List.of(12, 34, 3, 2, 3, 4, 12, 3), List.of(34, 3, 3)
                        ),
                        List.of(
                                List.of(3, 34, 2), List.of(34, 3, 3, 12, 2, 4, 12, 3)
                        ),
                        false
                )
        );
    }


    private static Stream<Arguments> equalsListTestData() {
        return Stream.of(
                Arguments.of(List.of(12, 34, 3, 2, 3, 4, 12, 3), List.of(34, 3, 3, 12, 2, 4, 12, 3), true),
                Arguments.of(List.of(12, 34, 3, 2, 3, 4, 12, 3), List.of(34, 3, 3, 12, 2, 4, 1, 3), false)
        );
    }
}