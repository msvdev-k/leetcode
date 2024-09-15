package ru.msvdev.leetcode.topInterview150.array;

/**
 * 6. Zigzag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * Example 3:
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * Constraints:
 * -- 1 <= s.length <= 1000
 * -- s consists of English letters (lower-case and upper-case), ',' and '.'.
 * -- 1 <= numRows <= 1000
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        int stringLength = s.length();
        int columnSize = 2 * numRows - 2;
        StringBuilder stringBuilder = new StringBuilder();

        int idx = 0;
        while (idx < stringLength) {
            stringBuilder.append(s.charAt(idx));
            idx += columnSize;
        }

        for (int i = 1; i < numRows - 1; i++) {
            idx = i;
            int idx2 = columnSize - i;
            while (idx < stringLength) {
                stringBuilder.append(s.charAt(idx));
                if (idx2 < stringLength) {
                    stringBuilder.append(s.charAt(idx2));
                }
                idx += columnSize;
                idx2 += columnSize;
            }
        }

        idx = numRows - 1;
        while (idx < stringLength) {
            stringBuilder.append(s.charAt(idx));
            idx += columnSize;
        }

        return stringBuilder.toString();
    }

}
