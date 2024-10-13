package ru.msvdev.leetcode.topInterview150.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

class N138CopyListWithRandomPointerTest {

    @ParameterizedTest
    @MethodSource("testData")
    void copyRandomList1(Integer[][] inOut) {
        // region Given
        var solution = new N138CopyListWithRandomPointer();
        var list = arrayToList(inOut);
        // endregion

        // region When
        var answer = solution.copyRandomList1(list);
        // endregion

        // region Then
        var ansArray = listToArray(answer);
        Assertions.assertEquals(inOut.length, ansArray.length);
        for (int i = 0; i < inOut.length; i++) {
            Assertions.assertArrayEquals(inOut[i], ansArray[i]);
        }
        // endregion
    }

    @ParameterizedTest
    @MethodSource("testData")
    void copyRandomList2(Integer[][] inOut) {
        // region Given
        var solution = new N138CopyListWithRandomPointer();
        var list = arrayToList(inOut);
        // endregion

        // region When
        var answer = solution.copyRandomList2(list);
        // endregion

        // region Then
        var ansArray = listToArray(answer);
        Assertions.assertEquals(inOut.length, ansArray.length);
        for (int i = 0; i < inOut.length; i++) {
            Assertions.assertArrayEquals(inOut[i], ansArray[i]);
        }
        // endregion
    }


    @ParameterizedTest
    @MethodSource("testData")
    void converterTest(Integer[][] inOut) {
        // region Given
        var list = arrayToList(inOut);
        // endregion

        // region When
        var ansArray = listToArray(list);
        // endregion

        // region Then
        Assertions.assertEquals(inOut.length, ansArray.length);
        for (int i = 0; i < inOut.length; i++) {
            Assertions.assertArrayEquals(inOut[i], ansArray[i]);
        }
        // endregion
    }


    private N138CopyListWithRandomPointer.Node arrayToList(Integer[][] array) {
        if (array.length == 0) return null;

        var nodeArrayList = new ArrayList<N138CopyListWithRandomPointer.Node>();

        var newList = new N138CopyListWithRandomPointer.Node(0);
        var currentNode = newList;

        for (Integer[] a : array) {
            var node = new N138CopyListWithRandomPointer.Node(a[0]);
            nodeArrayList.add(node);
            currentNode.next = node;
            currentNode = node;
        }

        for (int i = 0; i < array.length; i++) {
            final Integer randomIdx = array[i][1];
            if (randomIdx != null) {
                nodeArrayList.get(i).random = nodeArrayList.get(randomIdx);
            }
        }

        return newList.next;
    }


    private Integer[][] listToArray(N138CopyListWithRandomPointer.Node header) {
        if (header == null) return new Integer[0][];

        var nodeArrayList = new ArrayList<Integer[]>();
        var indexMap = new HashMap<N138CopyListWithRandomPointer.Node, Integer>();

        var currentNode = header;
        int idx = 0;
        while (currentNode != null) {
            nodeArrayList.add(new Integer[]{currentNode.val, null});
            indexMap.put(currentNode, idx);

            currentNode = currentNode.next;
            idx++;
        }

        currentNode = header;
        idx = 0;
        while (currentNode != null) {
            var randomNode = currentNode.random;
            if (randomNode != null) {
                nodeArrayList.get(idx)[1] = indexMap.get(randomNode);
            }

            currentNode = currentNode.next;
            idx++;
        }

        return nodeArrayList.toArray(new Integer[0][]);
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        (Object) new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}}
                ),
                Arguments.of(
                        (Object) new Integer[][]{{1, 1}, {2, 1}}
                ),
                Arguments.of(
                        (Object) new Integer[][]{{3, null}, {3, 0}, {3, null}}
                ),
                Arguments.of(
                        (Object) new Integer[][]{{3, 0}}
                ),
                Arguments.of(
                        (Object) new Integer[][]{}
                ),
                Arguments.of(
                        (Object) new Integer[][]{{1, 1}, {2, 1}}
                )

        );
    }
}