package ru.msvdev.tcode.exam202411;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Определить количество составных чисел (не простых) на отрезке от A до B включительно,
 * которые имеют количество делителей равное простому числу.
 * <p>
 * Формат входных данных
 * Строка содержащая два целых числа A и B, удовлетворяющих условию: 1 <= A < B < 1e14.
 * <p>
 * Формат выходных данных
 * Количество составных чисел.
 * <p>
 * Пример:
 * Ввод: 1 9
 * Вывод: 2
 */
public class Task04 {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextLong();
        long B = scanner.nextLong();

        if (A < 4) A = 4;
        if (B < 4) {
            System.out.println(0);
            return;
        }

        // Вспомогательные структуры данных
        int maxCountOfSimpleNum = (int) Math.sqrt(B) + 2;

        int[] simpleNumbers = new int[maxCountOfSimpleNum];
        int countOfSimpleNumbers = 0;
        Arrays.fill(simpleNumbers, 0);


        // Простые числа до A максимально необходимого количество
        simpleNumbers[0] = 2;
        simpleNumbers[1] = 3;
        simpleNumbers[2] = 5;
        simpleNumbers[3] = 7;
        countOfSimpleNumbers = 4;
        for (long number = 11; number < A && countOfSimpleNumbers < maxCountOfSimpleNum; number++) {
            long upperLimit = (long) Math.sqrt(number);
            boolean isSimple = true;

            for (int idx = 0; idx < countOfSimpleNumbers && simpleNumbers[idx] <= upperLimit; idx++) {
                if (number % simpleNumbers[idx] == 0) {
                    isSimple = false;
                    break;
                }
            }

            if (isSimple) {
                simpleNumbers[countOfSimpleNumbers] = (int) number;
                countOfSimpleNumbers++;
            }
        }


        // Факторизация чисел от A до B включительно
        int countForOut = 0;
        byte[] factors = new byte[maxCountOfSimpleNum];

        for (long i = A; i <= B; i++) {
            long upperLimit = (long) Math.sqrt(i) + 2;
            long number = i;

            Arrays.fill(factors, (byte) 1);
            for (int idx = 0; idx < countOfSimpleNumbers && simpleNumbers[idx] <= upperLimit; idx++) {
                while (number % simpleNumbers[idx] == 0) {
                    factors[idx]++;
                    number /= simpleNumbers[idx];
                }
            }

            if (number != 1) {
                if (countOfSimpleNumbers < maxCountOfSimpleNum) {
                    simpleNumbers[countOfSimpleNumbers] = (int) number;
                    countOfSimpleNumbers++;
                }
                continue;
            }

            int countOfDivisors = 1;
            for (int idx = 0; idx < countOfSimpleNumbers; idx++) {
                countOfDivisors *= factors[idx];
            }

            for (int idx = 0; idx < countOfSimpleNumbers; idx++) {
                if (countOfDivisors == simpleNumbers[idx]) {
                    countForOut++;
                    break;
                }
            }
        }


        System.out.println(countForOut);
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long A = scanner.nextLong();
        long B = scanner.nextLong();

        if (A < 4) A = 4;
        if (B < 4) {
            System.out.println(0);
            return;
        }

        // Вспомогательные структуры данных
        int maxCountOfSimpleNum = (int) Math.sqrt(B) + 2;

        int[] simpleNumbers = new int[maxCountOfSimpleNum];
        int countOfSimpleNumbers = 0;
        Arrays.fill(simpleNumbers, 0);


        // Простые числа до A максимально необходимого количество
        simpleNumbers[0] = 2;
        simpleNumbers[1] = 3;
        simpleNumbers[2] = 5;
        simpleNumbers[3] = 7;
        countOfSimpleNumbers = 4;
        for (long number = 11; number < A && countOfSimpleNumbers < maxCountOfSimpleNum; number++) {
            long upperLimit = (long) Math.sqrt(number);
            boolean isSimple = true;

            for (int idx = 0; idx < countOfSimpleNumbers && simpleNumbers[idx] <= upperLimit; idx++) {
                if (number % simpleNumbers[idx] == 0) {
                    isSimple = false;
                    break;
                }
            }

            if (isSimple) {
                simpleNumbers[countOfSimpleNumbers] = (int) number;
                countOfSimpleNumbers++;
            }
        }


        // Факторизация чисел от A до B включительно
        int countForOut = 0;

        for (long i = A; i <= B; i++) {
            long upperLimit = (long) Math.sqrt(i) + 2;
            long number = i;

            int countOfDivisors = 1;
            for (int idx = 0; idx < countOfSimpleNumbers && simpleNumbers[idx] <= upperLimit; idx++) {
                int factor = 1;
                while (number % simpleNumbers[idx] == 0) {
                    factor++;
                    number /= simpleNumbers[idx];
                }
                countOfDivisors *= factor;
            }

            if (number != 1) {
                if (countOfSimpleNumbers < maxCountOfSimpleNum) {
                    simpleNumbers[countOfSimpleNumbers] = (int) number;
                    countOfSimpleNumbers++;
                }
                continue;
            }


            for (int idx = 0; idx < countOfSimpleNumbers && simpleNumbers[idx] <= countOfDivisors; idx++) {
                if (countOfDivisors == simpleNumbers[idx]) {
                    countForOut++;
                    break;
                }
            }
        }


        System.out.println(countForOut);
    }
}
