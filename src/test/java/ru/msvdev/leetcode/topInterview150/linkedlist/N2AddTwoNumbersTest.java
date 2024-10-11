package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

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


    private boolean compareList(N2AddTwoNumbers.ListNode l1, N2AddTwoNumbers.ListNode l2) {
        if ((l1 == null && l2 != null) || (l1 != null && l2 == null)) return false;
        if (l1 == l2) return true;

        while (Objects.equals(l1, l2) && l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return Objects.equals(l1, l2);
    }

    private N2AddTwoNumbers.ListNode mapToList(int[] list) {
        final var numList = new N2AddTwoNumbers.ListNode(list[0]);
        var currentPosition = numList;
        for (int i = 1; i < list.length; i++) {
            var next = new N2AddTwoNumbers.ListNode(list[i]);
            currentPosition.next = next;
            currentPosition = next;
        }
        return numList;
    }


}