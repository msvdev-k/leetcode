package ru.msvdev.tcode.exam202411;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Преобразовать диапазоны чисел в их последовательность.
 * По указанной строке восстановить множество чисел, из которого указанная строка была построена.
 * Заметьте, что выводить множество нужно в отсортированном порядке.
 * <p>
 * Формат входных данных
 * Дана одна строка диапазонов значений разделённых запятыми. Гарантируется, что исходное множество
 * состоит только из целых положительных не повторяющихся чисел.
 * <p>
 * Формат выходных данных
 * Строка с отсортированным множеством чисел, перечисленных через пробел, из которого была
 * получена исходная строка.
 * <p>
 * Пример:
 * Ввод: 1-6,8-9,11
 * Вывод: 1 2 3 4 5 6 8 9 11
 */
public class Task01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        if (inputString.isBlank()) {
            System.out.println();
            return;
        }

        List<Integer> setOfNumbers = new ArrayList<>();
        for (String interval : inputString.split(",")) {
            String[] bounds = interval.split("-");

            if (bounds.length == 1) {
                setOfNumbers.add(Integer.valueOf(bounds[0]));

            } else {
                int start = Integer.parseInt(bounds[0]);
                int stop = Integer.parseInt(bounds[1]);
                for (int i = start; i <= stop; i++) {
                    setOfNumbers.add(i);
                }
            }
        }

        String output = setOfNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }
}
