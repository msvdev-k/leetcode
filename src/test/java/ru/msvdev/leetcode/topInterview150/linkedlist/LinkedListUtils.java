package ru.msvdev.leetcode.topInterview150.linkedlist;

import java.util.Objects;

public class LinkedListUtils {

    public static boolean compareList(ListNode l1, ListNode l2) {
        if ((l1 == null && l2 != null) || (l1 != null && l2 == null)) return false;
        if (l1 == l2) return true;

        while (Objects.equals(l1, l2) && l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return Objects.equals(l1, l2);
    }

    public static ListNode mapToList(int[] listValues) {
        final int n= listValues.length;
        if (n==0) return null;

        final var numList = new ListNode(listValues[0]);
        var currentPosition = numList;
        for (int i = 1; i < n; i++) {
            var next = new ListNode(listValues[i]);
            currentPosition.next = next;
            currentPosition = next;
        }
        return numList;
    }


    public static ListNode mapToList(int[] listValues, int cyclePose) {
        final int n = listValues.length;
        if (n == 0) return null;

        final var firstNode = new ListNode(listValues[0]);
        var previousNode = firstNode;
        for (int i = 1; i < n; i++) {
            final var nextNode = new ListNode(listValues[i]);
            previousNode.next = nextNode;
            previousNode = nextNode;
        }

        if (cyclePose >= 0) {
            var posNode = firstNode;
            for (int i = 0; i < cyclePose; i++) {
                posNode = posNode.next;
            }
            previousNode.next = posNode;
        }

        return firstNode;
    }
}
