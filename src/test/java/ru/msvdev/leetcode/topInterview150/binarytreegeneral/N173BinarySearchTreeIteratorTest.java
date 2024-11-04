package ru.msvdev.leetcode.topInterview150.binarytreegeneral;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class N173BinarySearchTreeIteratorTest {

    @ParameterizedTest
    @MethodSource("testData")
    void HashMapDoublyLinkedListLRUCache(String[] commands, Integer[] root, Object[] out) {
        N173BinarySearchTreeIterator.BSTIterator iterator = null;
        TreeNode rootTreeNode = TreeNodeUtils.mapToTree(root);

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("BSTIterator")) {
                iterator = new N173BinarySearchTreeIterator.ArrayListBSTIterator(rootTreeNode);
            } else {
                assertEquals(
                        out[i],
                        executor(command, iterator)
                );
            }
        }
    }


    private Object executor(String command, N173BinarySearchTreeIterator.BSTIterator iterator) {
        return switch (command) {
            case "next" -> iterator.next();
            case "hasNext" -> iterator.hasNext();
            default -> null;
        };
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        new String[]{"BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"},
                        new Integer[]{7, 3, 15, null, null, 9, 20},
                        new Object[]{null, 3, 7, true, 9, true, 15, true, 20, false}
                )
        );
    }

}