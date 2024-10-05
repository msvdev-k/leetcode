package ru.msvdev.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestUtils {


    public static <T extends Comparable<? super T>> boolean equalsListList(List<List<T>> first, List<List<T>> second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.size() != second.size()) return false;

        second = new ArrayList<>(second);
        for (List<T> firstItem : first) {
            boolean equals = false;
            for (int i = 0; i < second.size(); i++) {
                List<T> secondItem = second.get(i);
                equals = equalsList(firstItem, secondItem);
                if (equals) {
                    second.remove(secondItem);
                    break;
                }
            }
            if (!equals) return false;
        }

        return second.isEmpty();
    }

    /**
     * Сравнение двух неотсортированных списков
     * @param first первый список
     * @param second второй список
     */
    public static <T extends Comparable<? super T>> boolean equalsList(List<T> first, List<T> second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.size() != second.size()) return false;

        first = new ArrayList<>(first);
        second = new ArrayList<>(second);

        Collections.sort(first);
        Collections.sort(second);

        return first.equals(second);
    }

}
