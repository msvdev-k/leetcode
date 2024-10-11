package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.msvdev.leetcode.topInterview150.linkedlist.LinkedListUtils.compareList;
import static ru.msvdev.leetcode.topInterview150.linkedlist.LinkedListUtils.mapToList;

class N2AddTwoNumbersTest {

    @ParameterizedTest
    @MethodSource("testData")
    void addTwoNumbers(int[] l1, int[] l2, int[] out) {
        // region Given
        var solution = new N2AddTwoNumbers();
        var list1 = mapToList(l1);
        var list2 = mapToList(l2);
        var outList = mapToList(out);
        // endregion

        // region When
        var answer = solution.addTwoNumbers(list1, list2);
        // endregion

        // region Then
        assertTrue(compareList(outList, answer));
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new int[]{2, 4, 3},
                        new int[]{5, 6, 4},
                        new int[]{7, 0, 8}
                ),
                Arguments.of(
                        new int[]{0},
                        new int[]{0},
                        new int[]{0}
                ),
                Arguments.of(
                        new int[]{9, 9, 9, 9, 9, 9, 9},
                        new int[]{9, 9, 9, 9},
                        new int[]{8, 9, 9, 9, 0, 0, 0, 1}
                ),
                Arguments.of(
                        new int[]{2, 4, 9},
                        new int[]{5, 6, 4, 9},
                        new int[]{7, 0, 4, 0, 1}
                ),
                Arguments.of(
                        new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                        new int[]{5, 6, 4},
                        new int[]{6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
                )
        );
    }

}