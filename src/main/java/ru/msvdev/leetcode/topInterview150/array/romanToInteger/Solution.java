package ru.msvdev.leetcode.topInterview150.array.romanToInteger;

public class Solution {

    public int romanToInt(String s) {
        int number = 0;
        int previousNumber = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            int currentNumber = switch (ch) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> 0;
            };

            if (currentNumber < previousNumber) {
                number -= currentNumber;
            } else {
                number += currentNumber;
            }

            previousNumber = currentNumber;
        }

        return number;
    }
}
