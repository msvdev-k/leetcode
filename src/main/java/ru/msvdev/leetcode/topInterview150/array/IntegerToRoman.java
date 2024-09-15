package ru.msvdev.leetcode.topInterview150.array;

public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder romanBuilder = new StringBuilder();

        int thousands = num / 1000;
        int hundreds = (num / 100) % 10;
        int dozens = (num / 10) % 10;
        int units = num % 10;

        romanBuilder.append("M".repeat(Math.max(0, thousands)));

        if (hundreds == 9) {
            romanBuilder.append("CM");
            hundreds -= 9;
        } else if (hundreds >= 5) {
            romanBuilder.append("D");
            hundreds -= 5;
        } else if (hundreds == 4) {
            romanBuilder.append("CD");
            hundreds -= 4;
        }

        romanBuilder.append("C".repeat(Math.max(0, hundreds)));

        if (dozens == 9) {
            romanBuilder.append("XC");
            dozens -= 9;
        } else if (dozens >= 5) {
            romanBuilder.append("L");
            dozens -= 5;
        } else if (dozens == 4) {
            romanBuilder.append("XL");
            dozens -= 4;
        }

        romanBuilder.append("X".repeat(Math.max(0, dozens)));

        if (units == 9) {
            romanBuilder.append("IX");
            units -= 9;
        } else if (units >= 5) {
            romanBuilder.append("V");
            units -= 5;
        } else if (units == 4) {
            romanBuilder.append("IV");
            units -= 4;
        }

        romanBuilder.append("I".repeat(Math.max(0, units)));

        return romanBuilder.toString();
    }
}
