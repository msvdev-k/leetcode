package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N141LinkedListCycleTest {

    @ParameterizedTest
    @MethodSource("testData")
    void hasCycle1(int[] head, int pos, boolean out) {
        // region Given
        var solution = new N141LinkedListCycle();
        var list = getList(head, pos);
        // endregion

        // region When
        var answer = solution.hasCycle1(list);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void hasCycle2(int[] head, int pos, boolean out) {
        // region Given
        var solution = new N141LinkedListCycle();
        var list = getList(head, pos);
        // endregion

        // region When
        var answer = solution.hasCycle2(list);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void hasCycle3(int[] head, int pos, boolean out) {
        // region Given
        var solution = new N141LinkedListCycle();
        var list = getList(head, pos);
        // endregion

        // region When
        var answer = solution.hasCycle3(list);
        // endregion

        // region Then
        assertEquals(out, answer);
        // endregion
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 0, -4}, 1, true),
                Arguments.of(new int[]{1, 2}, 0, true),
                Arguments.of(new int[]{1}, -1, false),
                Arguments.of(
                        new int[]{-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5},
                        -1, false
                )
        );
    }


    private N141LinkedListCycle.ListNode getList(int[] head, int pos) {
        final int n = head.length;
        if (n == 0) return null;

        final var firstNode = new N141LinkedListCycle.ListNode(head[0]);
        var previousNode = firstNode;
        for (int i = 1; i < n; i++) {
            final var nextNode = new N141LinkedListCycle.ListNode(head[i]);
            previousNode.next = nextNode;
            previousNode = nextNode;
        }

        if (pos >= 0) {
            var posNode = firstNode;
            for (int i = 0; i < pos; i++) {
                posNode = posNode.next;
            }
            previousNode.next = posNode;
        }

        return firstNode;
    }

}