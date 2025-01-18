package ru.msvdev.tcode.exam202411;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Задача на восстановление пароля.
 * <p>
 * Дан набор символов из которых должен состоять пароль, причём каждый символ из набора должен встречаться
 * хотя бы один раз. Длина пароля не превосходит известного количества символов. Известна последовательность
 * набираемых на клавиатуре символов, в которой может оказаться пароль. Необходимо восстановить пароль или
 * определить, что восстановление невозможно.
 * <p>
 * Формат входных данных:
 * -- В первой строке ввода дана последовательность из строчных латинских букв набираемых на клавиатуре.
 * -- Во второй строке дан набор символов из которых должен состоять пароль.
 * -- В третьей строке указано число, определяющее максимальную длину пароля.
 * <p>
 * Формат выходных данных:
 * -- Вывести найденный пароль. Если вариантов несколько, то выбрать самую длинную последовательность.
 * Если несколько вариантов с одинаковой длиной, то выбрать самую правую последовательность.
 * -- Если восстановить пароль не удастся, вывести -1.
 * <p>
 * Ввод: abacaba
 * abc
 * 4
 * Вывод: caba
 */
public class Task03 {

    private static final int MAX_CHAR_COUNT = 26;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных
        String sequence = scanner.nextLine();
        String passwordChars = scanner.nextLine();
        int maxPasswordLength = scanner.nextInt();

        // Дополнительные структуры данных
        int sequenceLength = sequence.length();
        int countOfPasswordChars = passwordChars.length();

        boolean[] passwordCharMap = new boolean[MAX_CHAR_COUNT];
        Arrays.fill(passwordCharMap, false);
        for (int i = 0; i < countOfPasswordChars; i++) {
            int charIdx = passwordChars.charAt(i) - 'a';
            passwordCharMap[charIdx] = true;
        }

        int countOfPasswordCharactersInSubSequence = 0;
        int[] countMapOfPasswordCharactersInSubSequence = new int[MAX_CHAR_COUNT];
        Arrays.fill(countMapOfPasswordCharactersInSubSequence, 0);


        // Скользящее окно
        int lIdx = sequenceLength - 1, rIdx = sequenceLength;
        int passwordWindowLIdx = 0, passwordWindowRIdx = 0;

        while (lIdx >= 0) {

            if (rIdx - lIdx > maxPasswordLength) {
                rIdx--;
                int charRIdx = sequence.charAt(rIdx) - 'a';
                if (passwordCharMap[charRIdx]) {
                    if (countMapOfPasswordCharactersInSubSequence[charRIdx] > 1) {
                        countMapOfPasswordCharactersInSubSequence[charRIdx]--;

                    } else {
                        countMapOfPasswordCharactersInSubSequence[charRIdx] = 0;
                        countOfPasswordCharactersInSubSequence--;
                    }
                }
            }

            int charLIdx = sequence.charAt(lIdx) - 'a';

            if (passwordCharMap[charLIdx]) {
                if (countMapOfPasswordCharactersInSubSequence[charLIdx] == 0) {
                    countOfPasswordCharactersInSubSequence++;
                }
                countMapOfPasswordCharactersInSubSequence[charLIdx]++;

            } else {
                while (rIdx > lIdx) {
                    rIdx--;
                    int charRIdx = sequence.charAt(rIdx) - 'a';
                    if (passwordCharMap[charRIdx]) {
                        if (countMapOfPasswordCharactersInSubSequence[charRIdx] > 1) {
                            countMapOfPasswordCharactersInSubSequence[charRIdx]--;

                        } else {
                            countMapOfPasswordCharactersInSubSequence[charRIdx] = 0;
                            countOfPasswordCharactersInSubSequence--;
                        }
                    }
                }
            }

            if (countOfPasswordCharactersInSubSequence == countOfPasswordChars) {
                if (passwordWindowRIdx - passwordWindowLIdx < rIdx - lIdx) {
                    passwordWindowLIdx = lIdx;
                    passwordWindowRIdx = rIdx;
                }
            }

            lIdx--;
        }


        if (passwordWindowLIdx == passwordWindowRIdx) {
            System.out.println(-1);

        } else {
            String password = sequence.substring(passwordWindowLIdx, passwordWindowRIdx);
            System.out.println(password);
        }
    }
}
